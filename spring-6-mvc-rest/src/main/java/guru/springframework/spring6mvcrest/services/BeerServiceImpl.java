package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.Beer;
import guru.springframework.spring6mvcrest.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService{

    @Override
    public Beer getBeerById(UUID id){
        log.debug("Get Beer by id in service. Id : "+ id.toString());
        return Beer.builder()
                .id(id)
                .version(2)
                .beerName("Bira Gold")
                .beerStyle(BeerStyle.PILSNER)
                .upc("123456")
                .quantityOnHand(101)
                .price(BigDecimal.valueOf(200.50))
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
