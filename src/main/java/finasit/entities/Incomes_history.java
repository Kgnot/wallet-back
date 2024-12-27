package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Incomes_history")
@Data
public class Incomes_history {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_income_history")
    private int id_income_history;
    @Column(name = "id_income")
    private int id_income;
    @Column(name="id_income_type")
    private int id_income_type;

}
