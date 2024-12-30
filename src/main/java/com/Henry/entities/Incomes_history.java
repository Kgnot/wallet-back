package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Incomes_history")
@Data
public class Incomes_history {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_income_history")
    private int id_income_history;
    @ManyToOne
    @JoinColumn(name = "id_income",nullable = false)
    private Incomes incomes;
    @ManyToOne
    @JoinColumn(name = "id_income_type",nullable = false)
    private Incomes_types incomeType;

    // OTM
    @OneToMany(mappedBy = "incomeHistory")
    private List<Transaction> transactions;

}
