package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private int id_transaction;
    @ManyToOne
    @JoinColumn(name = "id_expense_history",nullable = false)
    private Expenses_history expenseHistory;
    @ManyToOne
    @JoinColumn(name = "id_income_history")
    private Incomes_history incomeHistory;
    @Column(name = "value")
    private double value;
    @ManyToOne
    @JoinColumn(name = "id_denomination")
    private Denominations denominations;
    @Column(name = "date")
    private Date date;
    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;
    @ManyToOne
    @JoinColumn(name = "id_wallet",nullable = false)
    private Wallets wallet;
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(name = "id_mood",nullable = false)
    private Moods mood;

}
