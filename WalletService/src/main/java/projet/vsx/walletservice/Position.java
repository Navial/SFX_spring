package projet.vsx.walletservice;

import lombok.*;

/*
* Simple POJO / DTO
* Sera utiliser pour ajouter une ou plusieurs positions.
* Ce sera cet objet qui sera envoyé pour indiquer le symbole
* et la quantité achetée de cette action.
*
* POST/wallet{username}
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    private String symbol; // Symbole de l'action ou "CASH" pour le cash
    private Integer quantity; // Quantité possédée

}
