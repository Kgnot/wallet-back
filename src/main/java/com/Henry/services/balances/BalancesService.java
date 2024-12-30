package com.Henry.services.balances;

import com.Henry.entities.Balances;
import com.Henry.entities.Users;

import java.util.List;

public interface BalancesService {

    List<Balances> findByUserId(Integer userId);
    Balances save(Balances balance, Users user);

}
