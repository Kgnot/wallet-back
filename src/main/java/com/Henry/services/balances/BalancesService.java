package com.Henry.services.balances;

import com.Henry.entities.Balances;

import java.util.List;

public interface BalancesService {

    List<Balances> findByUserEmail(String email);
    Balances save(Balances balance);

}
