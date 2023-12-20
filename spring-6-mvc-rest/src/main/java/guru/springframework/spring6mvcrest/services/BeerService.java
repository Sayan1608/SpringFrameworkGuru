package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    Optional<BeerDTO> getBeerById(UUID id);

    List<BeerDTO> listBeers();

    BeerDTO saveBeer(BeerDTO beer);

    BeerDTO updateBeerById(UUID beerId, BeerDTO beer);

    void deleteBeerById(UUID ud);

    BeerDTO patchBeerById(UUID id, BeerDTO beer);
}
