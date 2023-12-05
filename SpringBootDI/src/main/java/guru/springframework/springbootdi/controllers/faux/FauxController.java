package guru.springframework.springbootdi.controllers.faux;

import guru.springframework.springbootdi.services.faux.FauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class FauxController {

    @Autowired
    private final FauxService fauxService;

    public FauxController(@Qualifier("fauxService") FauxService fauxService) {
        this.fauxService = fauxService;
    }

    public String getDataSourceUrl(){
        return this.fauxService.getDataSourceString();
    }
}
