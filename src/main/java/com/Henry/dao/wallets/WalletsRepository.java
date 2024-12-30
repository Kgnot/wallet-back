package com.Henry.dao.wallets;

import com.Henry.entities.Wallets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletsRepository extends JpaRepository<Wallets,Integer> {
}
