package com.Henry.dao.balances;

import com.Henry.entities.Balances;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalancesRepository extends JpaRepository<Balances, Integer> {
    List<Balances> findByUserEmail(String email);
}
