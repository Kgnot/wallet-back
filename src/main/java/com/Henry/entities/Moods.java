package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Moods")
@Data
public class Moods {
    @Id
    @Column(name = "id_mood")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mood;
    @Column(name = "type")
    private String type;
    @Column(name = "valuation", nullable = false)
    private int valuation;

    // OTM
    @OneToMany(mappedBy = "mood")
    private List<Transaction> transactions;

}