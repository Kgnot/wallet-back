package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Expenses")
@Entity
@Data
public class Expenses {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_expense")
    private int id_expense;
    @Column(name = "id_user")
    private int id_user;
    @Column(name = "type")
    private String type;

}
