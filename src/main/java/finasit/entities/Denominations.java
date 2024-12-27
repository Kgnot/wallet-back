package finasit.entities;


import finasit.entities.transaction.Transaction;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Denominations")
@Data
public class Denominations {

    @Id
    @Column(name = "id_denomination")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_denomination;

    @Column(name = "denomination", length = 10,nullable = false)
    private String denomination;

    //OTM
    @OneToMany(mappedBy = "id_denomination")
    private List<Transaction> transactions;
}
