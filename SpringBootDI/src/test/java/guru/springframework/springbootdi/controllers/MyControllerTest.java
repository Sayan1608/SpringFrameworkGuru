package guru.springframework.springbootdi.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

    @Test
    void sayHello() {
        System.out.println("Inside sayHello method of MyControllerTest");
        MyController controller = new MyController();
        System.out.println(controller.sayHello());
    }
}