package com.Henry.services.wallets;

import com.Henry.dao.wallets.WalletsRepository;
import com.Henry.entities.Wallets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletsServiceImpl implements WalletsService{

    private final WalletsRepository repository;

    @Override
    public List<Wallets> findAll() {
        return repository.findAll();
    }

    @Override
    public Wallets findById(int id) {
        Optional<Wallets> wallet = repository.findById(id);
        return wallet.orElse(null);
    }
}
