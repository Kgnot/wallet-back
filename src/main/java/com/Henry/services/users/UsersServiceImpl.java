package com.Henry.services.users;

import com.Henry.dao.users.UsersRepository;
import com.Henry.dto.users.UsersDTO;
import com.Henry.entities.Users;
import com.Henry.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository repository;

    @Autowired
    public UsersServiceImpl(UsersRepository repository){
        this.repository =repository;
    }


    public UsersDTO convertToDTO(Users user) {
        return UsersDTO.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .build();
    }

    @Override
    public List<UsersDTO> findAll() {
        List<Users> users = repository.findAll();

        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Users findById(int id) {
        Optional<Users> userId = repository.findById(id);

        return userId.orElse(null);
    }

    @Override
    public Users save(Users user_rq) {
        Users user = UsersMapper.getInstance().toEntity(user_rq); // esto básicamente encripta
        return repository.save(user);
    }

    @Override
    public Users deleteById(int id) {
        Users aux = repository.findById(id).get();
        repository.deleteById(id);
        return repository.findById(id).isPresent()? null:aux;
    }

    @Override
    public Users findByEmail(String email) {
        return repository.findByEmail(email);
    }
}