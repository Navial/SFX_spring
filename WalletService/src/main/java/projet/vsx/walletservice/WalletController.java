package projet.vsx.walletservice;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class WalletController {
    private WalletService service;

    @GetMapping("/wallet/{username}/net-worth")
    public ResponseEntity<Double> getNetWorth(@PathVariable String username){
        double netWorth = service.getNetWorth(username);
        // TODO : 400 | UNAUTHORIZED si ce n'est pas l'investisseur connecté.

        if(netWorth == -1){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(netWorth, HttpStatus.OK);
    }

    @GetMapping("/wallet/{username}")
    public ResponseEntity<Set<PositionValue>> getOpenPositions(@PathVariable String username){
        Set<PositionValue> positions = service.getOpenPositions(username);
        if(positions == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @PostMapping("/wallet/{username}")
    public ResponseEntity<Position> addNewPosition(){
        return null;
    }
}
