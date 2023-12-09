package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listCustomers();
    Customer getCustomerById(UUID id);

    Customer saveCustomer(Customer customer);

    Customer updateCustomerById(UUID id,Customer customer);

    void deleteCustomerById(UUID id);

    Customer patchCustomerById(UUID id, Customer customer);


}
