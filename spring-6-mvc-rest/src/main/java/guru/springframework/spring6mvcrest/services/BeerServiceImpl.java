package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.BeerDTO;
import guru.springframework.spring6mvcrest.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService{

    Map<UUID, BeerDTO> beerMap = new HashMap<>();

    public BeerServiceImpl(){


        BeerDTO beer1 = BeerDTO.builder()
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

        BeerDTO beer2 = BeerDTO.builder()
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

        BeerDTO beer3 = BeerDTO.builder()
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
    public Optional<BeerDTO> getBeerById(UUID id){
        log.debug("Get Beer by id in service. Id : "+ id.toString());
        return Optional.of(beerMap.get(id)) ;
    }

    @Override
    public List<BeerDTO> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beer) {
        BeerDTO savedBeer = BeerDTO.builder()
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
    public BeerDTO updateBeerById(UUID beerId, BeerDTO beer) {
        BeerDTO updatedBeer = BeerDTO.builder()
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

    @Override
    public BeerDTO patchBeerById(UUID id, BeerDTO beer) {
        BeerDTO existing = beerMap.get(id);

        if (StringUtils.hasText(beer.getBeerName())) {
            existing.setBeerName(beer.getBeerName());
        }

        if (beer.getVersion() != null) {
            existing.setVersion(beer.getVersion());
        }

        if (beer.getBeerStyle() != null) {
            existing.setBeerStyle(beer.getBeerStyle());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existing.setUpc(beer.getUpc());
        }

        if (beer.getQuantityOnHand() != null) {
            existing.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (beer.getPrice() != null) {
            existing.setPrice(beer.getPrice());
        }

        return existing;

    }
}
