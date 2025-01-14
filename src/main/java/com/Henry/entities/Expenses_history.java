package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Expenses_history")
@Data
public class Expenses_history {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_expense_history")
    private int id_expense_history;

    @ManyToOne
    @JoinColumn(name = "id_expense")
    private Expenses expense;

    @ManyToOne
    @JoinColumn(name = "id_expense_type")
    private Expenses_types expenseType;


    //One to Many
    @OneToMany(mappedBy = "expenseHistory")
    private List<Transaction> transactions;

}