package guru.springframework.springbootdi.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SetterInjectedControllerTest {

    @Autowired
    private SetterInjectedController setterInjectedController;

//    @BeforeEach
//    void setUp() {
//        setterInjectedController = new SetterInjectedController();
//        setterInjectedController.setGreetingService(new GreetingServiceImpl());
//    }

    @Test
    void sayHello() {
        System.out.println(setterInjectedController.sayHello());
    }
}