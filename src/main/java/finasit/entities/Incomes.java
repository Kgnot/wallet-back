package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Incomes")
@Data
public class Incomes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incomes")
    private int id_incomes;
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private Users id_user;
    @Column(name = "type",nullable = false)
    private String type;

    // One to Many
    @OneToMany(mappedBy = "id_income")
    private List<Incomes_history> histories;


}
