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
    private Expenses id_expense;

    @ManyToOne
    @JoinColumn(name = "id_expense_type")
    private Expenses_types id_expense_type;


    //One to Many
    @OneToMany(mappedBy = "id_expense_history")
    private List<Transaction> transactions;

}