package com.Henry.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Goals")
@Data
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_goal")
    private int id_goal;
    @Column(name = "date")
    private Date date;
    //    Relation many to one:
    @ManyToOne
    @JoinColumn(name = "id_goal_type", nullable = false)
    private Goals_types id_goal_type;
    @ManyToOne
    @JoinColumn(name="id_user",nullable = false)
    @JsonBackReference
    private Users user;
}
