package guru.springframework.spring6mvcrest.controllers;

import guru.springframework.spring6mvcrest.model.Customer;
import guru.springframework.spring6mvcrest.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    public static final String CUSTOMER_PATH = "/api/v1/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    private final CustomerService customerService;

    @GetMapping(CUSTOMER_PATH)
    public List<Customer> listCustomers(){
        return this.customerService.listCustomers();
    }

    @GetMapping(CUSTOMER_PATH_ID)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId){
        return this.customerService.getCustomerById(customerId);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        Customer savedCustomer = this.customerService.saveCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer");

        return new ResponseEntity<>(savedCustomer,headers, HttpStatus.CREATED);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<Customer> updateCustomerById(@PathVariable("customerId") UUID customerId,@RequestBody Customer customer){
        Customer updatedCustomer = this.customerService.updateCustomerById(customerId, customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/customer" + updatedCustomer.getId());

        return new ResponseEntity<>(updatedCustomer,headers,HttpStatus.OK);

    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable("customerId") UUID customerId){
        this.customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<Customer> patchCustomerById(@PathVariable("customerId") UUID customerId,@RequestBody Customer customer){
        Customer patchedCustomer = this.customerService.patchCustomerById(customerId,customer);
        return new ResponseEntity<>(patchedCustomer,HttpStatus.OK);
    }
}
