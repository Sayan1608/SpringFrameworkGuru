package guru.springframework.springbootdi.controllers;

import guru.springframework.springbootdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    @Autowired
    @Qualifier("setterInjectionService")
    public void setGreetingService(GreetingService greetingService) {
        System.out.println("Setter Method of SetterInjectedController is invoked");
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
