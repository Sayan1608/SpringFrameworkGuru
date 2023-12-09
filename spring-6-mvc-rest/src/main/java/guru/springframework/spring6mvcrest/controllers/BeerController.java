package guru.springframework.spring6mvcrest.controllers;

import guru.springframework.spring6mvcrest.model.Beer;
import guru.springframework.spring6mvcrest.services.BeerService;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        log.debug("Get Beer By Id in Controller.Id : 12345 asdfsssd " );
        return this.beerService.getBeerById(beerId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){
        return this.beerService.listBeers();
    }

    @PostMapping
    public ResponseEntity<Beer> saveBeer(@RequestBody Beer beer){
        Beer savedBeer = this.beerService.saveBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId());
        return new ResponseEntity<>(savedBeer,headers, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity<Beer> updateBeerById(@PathVariable UUID beerId, @RequestBody Beer beer){
        Beer updateBeer = this.beerService.updateBeerById(beerId, beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + updateBeer.getId());

        return new ResponseEntity<>(updateBeer,headers,HttpStatus.OK);

    }

    @DeleteMapping("{beerId}")
    public ResponseEntity<HttpStatus> deleteBeerById(@PathVariable("beerId") UUID beerId){
        this.beerService.deleteBeerById(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
