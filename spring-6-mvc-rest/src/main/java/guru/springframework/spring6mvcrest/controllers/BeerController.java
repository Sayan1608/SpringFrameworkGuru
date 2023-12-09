package guru.springframework.spring6mvcrest.controllers;

import guru.springframework.spring6mvcrest.model.Beer;
import guru.springframework.spring6mvcrest.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("Get Beer By Id in Controller.Id : " + beerId.toString());
        return this.beerService.getBeerById(beerId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){
        return this.beerService.listBeers();
    }
}
