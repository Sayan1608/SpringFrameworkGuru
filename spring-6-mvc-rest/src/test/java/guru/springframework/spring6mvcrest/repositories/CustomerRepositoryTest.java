package guru.springframework.spring6mvcrest.repositories;

import guru.springframework.spring6mvcrest.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testSaveCustomer(){
        Customer savedCustomer = customerRepository.save(Customer.builder()
                        .customerName("Customer Name")
                .build());

        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerName()).isNotNull();
    }

}