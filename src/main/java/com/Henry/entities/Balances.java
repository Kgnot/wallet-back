package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "balances")
@Data
public class Balances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_balance")
    private int id_balance;
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private Users id_user;
    @ManyToOne
    @JoinColumn(name = "id_wallet",nullable = false)
    private Wallets id_wallet;
    @Column(name="amount",nullable = false)
    private double amount;

}