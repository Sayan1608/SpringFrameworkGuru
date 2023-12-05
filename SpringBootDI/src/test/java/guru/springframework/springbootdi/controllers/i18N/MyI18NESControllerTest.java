package guru.springframework.springbootdi.controllers.i18N;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"ES", "Dev"})
class MyI18NESControllerTest {

    @Autowired
    private  MyI18NController myI18NController;

    @Test
    void sayHello() {
        System.out.println(this.myI18NController.sayHello());
    }
}