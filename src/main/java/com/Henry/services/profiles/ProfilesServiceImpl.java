package com.Henry.services.profiles;

import com.Henry.dao.profiles.ProfilesRepository;
import com.Henry.dto.profile.ProfileDTO;
import com.Henry.entities.Profiles;
import com.Henry.mapper.any.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfilesServiceImpl implements ProfilesService {

    private final ProfilesRepository repository;
    private final Mapper mapper;




    @Override
    public void save(Profiles profile) {
        repository.save(profile);
    }

    @Override
    public ProfileDTO findByUser(String email) {
        Profiles profile = repository.findByUser_Email(email).
                orElseThrow(()-> new RuntimeException("Perfil no encontrado"));

        return mapper.convertProfileToDTO(profile);
    }
}
