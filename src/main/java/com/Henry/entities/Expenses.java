package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "Expenses")
@Entity
@Data
public class Expenses {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_expense")
    private int id_expense;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users id_user;
    @Column(name = "type")
    private String type;
    // relations one to many :
    @OneToMany(mappedBy = "id_expense")
    private List<Expenses_history> histories;

}