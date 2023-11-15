package projet.vsx.walletservice;

import lombok.*;

/*
 * Simple POJO / DTO
 * Sera utiliser pour la liste des positions ouvertes où la quantité est >0.
 *
 * GET/wallet/{username}
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PositionValue {

    private String symbol;
    private Integer quantity;
    private double prices;

}
