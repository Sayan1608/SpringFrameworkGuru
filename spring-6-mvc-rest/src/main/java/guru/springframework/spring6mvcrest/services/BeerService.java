package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    Optional<Beer> getBeerById(UUID id);

    List<Beer> listBeers();

    Beer saveBeer(Beer beer);

    Beer updateBeerById(UUID beerId, Beer beer);

    void deleteBeerById(UUID ud);

    Beer patchBeerById(UUID id, Beer beer);
}
