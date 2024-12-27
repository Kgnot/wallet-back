package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Entity
@Table(name = "Goals")
@Data
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_goal")
    private int id_goal;
    @Column(name = "id_user")
    private int id_user;
    @Column(name="date")
    private Date date;
    @Column(name="id_goal_type")
    private int id_goal_type;


}
