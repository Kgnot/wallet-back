package finasit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    //one to many:
    @OneToMany(mappedBy = "id_income_type")
    @JsonIgnore // Posiblemente haremos manage referenced
    private List<Incomes_history> histories;
}
