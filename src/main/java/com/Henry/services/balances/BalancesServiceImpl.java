package com.Henry.services.balances;

import com.Henry.dao.balances.BalancesRepository;
import com.Henry.entities.Balances;
import com.Henry.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BalancesServiceImpl implements BalancesService{

    private final BalancesRepository repository;

    @Override
    public List<Balances> findByUserId(Integer userId) {
        return repository.findByUsersId(userId);
    }

    @Override
    public Balances save(Balances balance, Users user) {
        return repository.save(balance, user);
    }
}
