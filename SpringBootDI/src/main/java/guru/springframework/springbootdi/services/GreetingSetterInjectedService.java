package guru.springframework.springbootdi.services;

import org.springframework.stereotype.Service;

@Service("setterInjectionService")
public class GreetingSetterInjectedService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hey! I am setting a greeting!!";
    }
}
