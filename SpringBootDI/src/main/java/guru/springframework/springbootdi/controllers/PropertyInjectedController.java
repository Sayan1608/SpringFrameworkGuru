package guru.springframework.springbootdi.controllers;

import guru.springframework.springbootdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    @Qualifier("propertyInjectionService")
    GreetingService greetingService;

    public String sayHello(){
      return greetingService.sayGreeting();
    }
}
