package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Balances")
@Data
public class Balances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_balance")
    private int id_balance;
    @Column(name = "id_user")
    private int id_user;
    @Column(name = "id_wallet")
    private int id_wallet;
    @Column(name="amount")
    private double amount;

}
