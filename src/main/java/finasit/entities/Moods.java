package finasit.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Moods")
@Data
public class Moods {
    @Id
    @Column(name = "id_mood")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mood;

    @Column(name = "id_user")
    private int id_user;
    @Column(name = "type")
    private String type;

}
