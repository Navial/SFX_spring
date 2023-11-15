package projet.vsx.walletservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="wallets")
public class Wallet {
    @Id
    private String investorUsername;
    private String symbol; // Symbole de l'action ou "CASH" pour le cash
    private Integer quantity; // Quantité possédée


}
