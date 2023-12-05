package guru.springframework.springbootdi.services.i18N;

import guru.springframework.springbootdi.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("i18NService")
@Profile("ES")
public class SpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hola Munda-ES";
    }
}
