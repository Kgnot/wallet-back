package com.Henry.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Incomes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Incomes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_income")
    private int id_income;
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private Users user;
    @Column(name = "type",nullable = false)
    private String type;

    // One to Many
    @OneToMany(mappedBy = "incomes")
    private List<Incomes_history> histories;

}