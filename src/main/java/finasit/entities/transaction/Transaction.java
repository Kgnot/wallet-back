package finasit.entities.transaction;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private int id_transaction;
    @Column(name = "id_expenses_history")
    private String id_expenses_history;
    @Column(name = "id_incomes_history")
    private String id_incomes_history;
    @Column(name = "value")
    private double value;
    @Column(name = "id_denomination")
    private int id_denomination;
    @Column(name = "date")
    private Date date;
    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;
    @Column(name = "id_wallet")
    private int id_wallet;
    @Column(name = "id_user")
    private int id_user;
    @Column(name = "id_mood")
    private int id_mood;

}
