package guru.springframework.springbootdi.controllers.faux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"Prod", "EN"})
class FauxControllerTest {

    @Autowired
    private FauxController fauxController;

    @Test
    void getDataSourceUrl() {
        System.out.println(this.fauxController.getDataSourceUrl());
    }
}