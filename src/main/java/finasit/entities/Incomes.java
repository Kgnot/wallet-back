package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Incomes")
@Data
public class Incomes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incomes")
    private int id_incomes;
    @Column(name = "id_user")
    private int id_user;
    @Column(name = "type",nullable = false)
    private String type;


}
