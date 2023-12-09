package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);

    List<Beer> listBeers();

    Beer saveBeer(Beer beer);

    Beer updateBeerById(UUID beerId, Beer beer);
}
