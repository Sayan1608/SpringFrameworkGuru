package guru.springframework.springbootdi.services.faux;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("fauxService")
@Profile("Prod")
public class FauxServiceProdImpl implements FauxService{
    @Override
    public String getDataSourceString() {
        return "Production Datasource URl";
    }
}
