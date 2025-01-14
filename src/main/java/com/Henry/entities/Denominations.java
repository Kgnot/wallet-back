package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Denominations")
@Data
public class Denominations {

    @Id
    @Column(name = "id_denomination")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_denomination;

    @Column(name = "denomination", length = 10,nullable = false)
    private String denomination;

    //OTM
    @OneToMany(mappedBy = "denominations")
    private List<Transaction> transactions;
}

