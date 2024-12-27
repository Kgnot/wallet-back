package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Expenses_types")
@Data
public class Expenses_types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_expense_type")
    private int id_expense_type;

    @Column(name="type", nullable = false , length = 255)
    private String type;
}
