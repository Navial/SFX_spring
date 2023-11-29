package projet.vsx.walletservice;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@AllArgsConstructor
@RestController
public class WalletController {
    private WalletService service;

    @GetMapping("/wallet/{username}/net-worth")
    public ResponseEntity<Double> getNetWorth(@PathVariable String username){
        double networth = service.getNetWorth(username);
        if(networth < 0)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(networth, HttpStatus.OK);
    }

    @GetMapping("/wallet/{username}")
    public ResponseEntity<Set<PositionValue>> getOpenPositions(@PathVariable String username){
        Set<PositionValue> positions = service.getOpenPositions(username);
        if(positions == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @PostMapping("/wallet/{username}")
    public ResponseEntity<Set<Wallet>> addPosition(@PathVariable String username, @RequestBody Set<Position> newPositions){
        Set<Wallet> actualWallet = service.addPositions(username, newPositions);
        if(actualWallet == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(actualWallet, HttpStatus.OK);
    }
}
