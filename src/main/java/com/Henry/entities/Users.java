package com.Henry.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_user;
    @Column(name = "nickname", length = 30,unique = true)
    private String nickname;
    @Column(name = "email", length = 70, nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    //    Relation One to Many
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Goals> goals;
    @OneToMany(mappedBy = "user")
    private List<Expenses> expenses;
    @OneToMany(mappedBy = "user")
    private List<Balances> balances;
    @OneToMany(mappedBy = "user")
    private List<Incomes> incomes;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
    //    One to One
    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private Profiles profile;

    /* Constructor*/
    public Users(String nickname,String email, String password){
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}