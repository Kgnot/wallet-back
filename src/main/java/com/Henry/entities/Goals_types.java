package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Goals_types")
@Data
public class Goals_types {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_goal_type")
    private int id_goal_type;
    @Column(name="type", nullable = false, length = 255)
    private String type;


    //    Relation one to many - Goals
    @OneToMany(mappedBy = "id_goal_type")
    private List<Goals> goals;
}
