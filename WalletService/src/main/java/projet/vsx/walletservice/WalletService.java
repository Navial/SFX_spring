package projet.vsx.walletservice;

import java.util.HashSet;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@AllArgsConstructor
@Service
public class WalletService {
    private WalletRepository repository;
    private PriceProxy priceProxy;

    //@GetMapping("/wallet/{username}/net-worth")
    //public ResponseEntity<Double> getNetWorth(){
    public double getNetWorth(String username){
        // Get a set of wallet with all the positions of the user
        Set<Wallet> wallets =  repository.getAllByInvestorUsername(username);
        if(wallets == null)
            return -1;

        double netWorth = 0.0;
        for ( Wallet wallet : wallets ){
            Double price = priceProxy.getPriceForTicker(wallet.getSymbol()).getValue();
            netWorth += wallet.getQuantity() * price;
        }
        return netWorth;
    }

    //@GetMapping("/wallet/{username}")
    //public ResponseEntity<PositionValue> getOpenPositions(){
    public Set<PositionValue> getOpenPositions(String username){
        Set<PositionValue> positions = new HashSet<>();
        Set<Wallet> wallets =  repository.getAllByInvestorUsername(username);
        // Investor not found
        if(wallets == null)
            return null;

        for(Wallet wallet : wallets){
            PositionValue position = new PositionValue();
            Double price = priceProxy.getPriceForTicker(wallet.getSymbol()).getValue();
            position.setPrice(price);
            position.setSymbol(wallet.getSymbol());
            position.setQuantity(wallet.getQuantity());
            positions.add(position);
        }
        return positions;
    }

    //@PostMapping("/wallet/{username}")
    //public ResponseEntity<Position> addNewPosition(){


}
