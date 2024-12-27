package finasit.entities;

import finasit.entities.transaction.Transaction;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Moods")
@Data
public class Moods {
    @Id
    @Column(name = "id_mood")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mood;
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private Users id_user;
    @Column(name = "type")
    private String type;

    // OTM
    @OneToMany(mappedBy = "id_mood")
    private List<Transaction> transactions;

}
