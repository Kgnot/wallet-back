package com.Henry.services.wallets;

import com.Henry.entities.Wallets;

import java.util.List;

public interface WalletsService {

    List<Wallets> findAll();

    Wallets findById(int id);
}
