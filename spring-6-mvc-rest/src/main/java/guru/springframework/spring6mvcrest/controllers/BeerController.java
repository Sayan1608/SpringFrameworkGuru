package guru.springframework.spring6mvcrest.controllers;

import guru.springframework.spring6mvcrest.model.Beer;
import guru.springframework.spring6mvcrest.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
//@RequestMapping("/api/v1/beer")
public class BeerController {
    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";
    private final BeerService beerService;

    @GetMapping(BEER_PATH_ID)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("Get Beer By Id in Controller.Id : 12345 asdfsssd " );
        return this.beerService.getBeerById(beerId);
    }

    @GetMapping(BEER_PATH)
    public List<Beer> listBeers(){
        return this.beerService.listBeers();
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity<Beer> saveBeer(@RequestBody Beer beer){
        Beer savedBeer = this.beerService.saveBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId());
        return new ResponseEntity<>(savedBeer,headers, HttpStatus.CREATED);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity<Beer> updateBeerById(@PathVariable UUID beerId, @RequestBody Beer beer){
        Beer updateBeer = this.beerService.updateBeerById(beerId, beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + updateBeer.getId());

        return new ResponseEntity<>(updateBeer,headers,HttpStatus.OK);

    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity<HttpStatus> deleteBeerById(@PathVariable("beerId") UUID beerId){
        this.beerService.deleteBeerById(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity<Beer> patchBeerById(@PathVariable UUID beerId, @RequestBody Beer beer){
        Beer patchedBeer = this.beerService.patchBeerById(beerId, beer);
        return new ResponseEntity<>(patchedBeer,HttpStatus.OK);
    }

}
