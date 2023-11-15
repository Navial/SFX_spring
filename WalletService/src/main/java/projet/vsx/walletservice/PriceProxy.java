package projet.vsx.walletservice;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(name = "price")
public interface PriceProxy {
    @GetMapping("/price/{ticker}")
    be.vinci.ipl.price.Price getPriceForTicker(@Param("ticker") String ticker);

}
