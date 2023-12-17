package guru.springframework.spring6mvcrest.services;

import guru.springframework.spring6mvcrest.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    Map<UUID,Customer> customerMap = new HashMap<>();

    public CustomerServiceImpl(){
        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("John Doe")
                .version("1")
                .createdDate(LocalDateTime.now())
                .lastUpdatedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Bob Jones")
                .version("2")
                .createdDate(LocalDateTime.now())
                .lastUpdatedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Ema Clark")
                .version("3")
                .createdDate(LocalDateTime.now())
                .lastUpdatedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }
    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {

        return  Optional.of(customerMap.get(id));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .version(customer.getVersion())
                .customerName(customer.getCustomerName())
                .createdDate(LocalDateTime.now())
                .lastUpdatedDate(LocalDateTime.now())
                .build();
        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public Customer updateCustomerById(UUID id, Customer customer) {
        Customer updatedCustomer = Customer.builder()
                .id(id)
                .customerName(customer.getCustomerName())
                .version(customer.getVersion())
                .lastUpdatedDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .build();
        customerMap.put(id,updatedCustomer);
        return updatedCustomer;
    }

    @Override
    public void deleteCustomerById(UUID id) {
        customerMap.remove(id);
    }

    @Override
    public Customer patchCustomerById(UUID id, Customer customer) {
        Customer existing = customerMap.get(id);
        if(StringUtils.hasText(customer.getCustomerName())){
            existing.setCustomerName(customer.getCustomerName());
        }

        if(StringUtils.hasText(customer.getVersion())){
            existing.setVersion(customer.getVersion());
        }

        return existing;
    }
}
