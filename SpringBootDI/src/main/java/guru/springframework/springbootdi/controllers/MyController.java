package guru.springframework.springbootdi.controllers;

import guru.springframework.springbootdi.services.GreetingService;
import guru.springframework.springbootdi.services.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private  final GreetingService greetingService;

    public MyController() {
        greetingService = new GreetingServiceImpl();
    }

    public String sayHello(){
       return greetingService.sayGreeting();
    }
}
