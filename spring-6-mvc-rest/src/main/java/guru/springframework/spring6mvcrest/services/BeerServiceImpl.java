package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.Beer;
import guru.springframework.spring6mvcrest.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService{

    Map<UUID,Beer> beerMap = new HashMap<>();

    public BeerServiceImpl(){


        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Budweiser Magnum")
                .beerStyle(BeerStyle.SAISON)
                .upc("56785")
                .quantityOnHand(99)
                .price(BigDecimal.valueOf(159.99))
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(3)
                .beerName("Kingfisher Premium")
                .beerStyle(BeerStyle.GOSE)
                .upc("89785")
                .quantityOnHand(120)
                .price(BigDecimal.valueOf(139.99))
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(4)
                .beerName("Heineken")
                .beerStyle(BeerStyle.SAISON)
                .upc("110055")
                .quantityOnHand(45)
                .price(BigDecimal.valueOf(240.85))
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public Beer getBeerById(UUID id){
        log.debug("Get Beer by id in service. Id : "+ id.toString());
        return beerMap.get(id);
    }

    @Override
    public List<Beer> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer saveBeer(Beer beer) {
        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .version(beer.getVersion())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .upc(beer.getUpc())
                .quantityOnHand(beer.getQuantityOnHand())
                .price(beer.getPrice())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);
        return savedBeer;
    }

    @Override
    public Beer updateBeerById(UUID beerId, Beer beer) {
        Beer updatedBeer = Beer.builder()
                .id(beerId)
                .version(beer.getVersion())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .price(beer.getPrice())
                .upc(beer.getUpc())
                .quantityOnHand(beer.getQuantityOnHand())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put(beerId, updatedBeer);

        return  updatedBeer;
    }

    @Override
    public void deleteBeerById(UUID id) {
        beerMap.remove(id);
    }
}
