package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> listCustomers();
   Optional<CustomerDTO> getCustomerById(UUID id);

    CustomerDTO saveCustomer(CustomerDTO customer);

    CustomerDTO updateCustomerById(UUID id, CustomerDTO customer);

    void deleteCustomerById(UUID id);

    CustomerDTO patchCustomerById(UUID id, CustomerDTO customer);


}
