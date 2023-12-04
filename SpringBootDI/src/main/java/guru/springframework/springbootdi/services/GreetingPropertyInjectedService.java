package guru.springframework.springbootdi.services;

import org.springframework.stereotype.Service;

@Service("propertyInjectionService")
public class GreetingPropertyInjectedService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Friends don't let friends property injection!!";
    }
}
