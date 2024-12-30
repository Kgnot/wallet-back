package com.Henry.dao.balances;

import com.Henry.entities.Balances;
import com.Henry.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalancesRepository extends JpaRepository<Balances, Integer> {
    List<Balances> findByUsersId(Integer userid);
    Balances save(Balances balance, Users userid);
}
