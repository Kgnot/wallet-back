package com.Henry.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Profiles")
@Data
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private int id_profile;
    @OneToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id_user")
    private Users id_user;
    @Column(name = "first_name",nullable = false)
    private String first_name;
    @Column(name = "last_name",nullable = false)
    private String last_name;
    @Column(name = "img",nullable = false)
    private String img;
    @Column(name = "description")
    private String description;

}
