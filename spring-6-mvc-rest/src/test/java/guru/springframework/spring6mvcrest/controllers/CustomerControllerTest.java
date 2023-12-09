package guru.springframework.spring6mvcrest.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerControllerTest {
    @Autowired
    CustomerController customerController ;

    @Test
    void listCustomers() {
        System.out.println(this.customerController.listCustomers());
    }
}