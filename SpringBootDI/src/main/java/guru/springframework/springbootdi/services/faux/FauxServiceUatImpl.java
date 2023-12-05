package guru.springframework.springbootdi.services.faux;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("fauxService")
@Profile("Uat")
public class FauxServiceUatImpl implements FauxService{
    @Override
    public String getDataSourceString() {
        return "UAT Datasource URL";
    }
}
