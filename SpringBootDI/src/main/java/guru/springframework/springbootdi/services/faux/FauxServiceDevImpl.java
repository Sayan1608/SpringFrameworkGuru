package guru.springframework.springbootdi.services.faux;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("fauxService")
@Profile({"Dev", "default"})
public class FauxServiceDevImpl implements FauxService {
    @Override
    public String getDataSourceString() {
        return "Dev DataSource URL";
    }
}
