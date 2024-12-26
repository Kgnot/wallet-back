package finasit.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private int id_user;
    @Column(name = "nickname", length = 30 , nullable = false , unique = true)
    private String nickname;
    @Column(name="email",length = 70 , nullable = false , unique = true)
    private String email;
    @Column(name="password" , nullable = false)
    private String password;

}
