package projet.vsx.walletservice;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class WalletController {
    private WalletService ws;

    @GetMapping("/wallet/{username}/net-worth")
    public ResponseEntity<Double> getNetWorth(){
        return null;
    }

    @GetMapping("/wallet/{username}")
    public ResponseEntity<PositionValue> getOpenPositions(){
        return null;
    }

    @PostMapping("/wallet/{username}")
    public ResponseEntity<Position> addNewPosition(){
        return null;
    }
}
