package com.Henry.services.balances;

import com.Henry.dao.balances.BalancesRepository;
import com.Henry.entities.Balances;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BalancesServiceImpl implements BalancesService{

    private final BalancesRepository repository;

    @Override
    public List<Balances> findByUserEmail(String email) {
        return repository.findByUserEmail(email);
    }

    @Override
    public Balances save(Balances balance) {
        return repository.save(balance);
    }
}
