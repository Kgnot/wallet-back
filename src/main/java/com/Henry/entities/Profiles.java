package com.Henry.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Profiles")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private int id_profile;
    @OneToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id_user")
    @JsonBackReference
    private Users user;
    @Column(name = "first_name",nullable = false)
    private String first_name;
    @Column(name = "last_name",nullable = false)
    private String last_name;
    @Column(name = "img")
    private String img;
    @Column(name = "description")
    private String description;

}
