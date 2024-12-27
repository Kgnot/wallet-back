package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Expenses_history")
@Data
public class Expenses_history {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_expense_history")
    private int id_expense_history;

    @Column(name = "id_expense")
    private int id_expense;

    @Column(name = "id_expense_type")
    private int id_expense_type;


}
