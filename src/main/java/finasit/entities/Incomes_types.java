package finasit.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Incomes_types")
@Data
public class Incomes_types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_income_type")
    private int id_income_type;
    @Column(name = "type")
    private String type;
}
