package com.Henry.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Expenses_types")
@Data
public class Expenses_types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_expense_type")
    private int id_expense_type;

    @Column(name="type", nullable = false , length = 255)
    private String type;

    // one to many :
    @OneToMany(mappedBy = "id_expense_type")
    @JsonIgnore // we'll not use it
    private List<Expenses_history> histories;

}