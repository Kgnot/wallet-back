package com.Henry.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Wallets")
@Data
public class Wallets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wallet")
    private int id_wallet;
    @Column(name = "wallet_type")
    private String wallet_type;
    @Column(name = "wallet_img_url")
    private String wallet_img_url;
    // One to many
    @OneToMany(mappedBy = "id_wallet")
    @JsonIgnore
    private List<Balances> balances;
    @OneToMany(mappedBy = "id_wallet")
    private List<Transaction> transactions;

}
