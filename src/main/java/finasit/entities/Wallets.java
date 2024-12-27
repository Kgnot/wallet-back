package finasit.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Wallets")
@Data
public class Wallets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wallet")
    private int id_wallet;
    @Column(name = "wallet_type")
    private String wallet_type;
    @Column(name = "wallet_img_url")
    private String wallet_img_url;
}
