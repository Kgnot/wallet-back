package com.Henry.entities;

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
    @OneToMany(mappedBy = "id_user")
    private List<Goals> goals;
    @OneToMany(mappedBy = "id_user")
    private List<Expenses> expenses;
    @OneToMany(mappedBy = "id_user")
    private List<Balances> balances;
    @OneToMany(mappedBy = "id_user")
    private List<Incomes> incomes;
    @OneToMany(mappedBy = "id_user")
    private List<Transaction> transactions;
    //    One to One
    @OneToOne(mappedBy = "id_user")
    private Profiles profile;

    /* Constructor*/
    public Users(String nickname,String email, String password){
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}