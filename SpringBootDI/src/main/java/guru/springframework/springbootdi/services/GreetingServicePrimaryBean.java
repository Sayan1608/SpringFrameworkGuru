package guru.springframework.springbootdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetingServicePrimaryBean implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello from Primary Bean";
    }
}
