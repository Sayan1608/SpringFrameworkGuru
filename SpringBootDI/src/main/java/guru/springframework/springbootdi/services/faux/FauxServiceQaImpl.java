package guru.springframework.springbootdi.services.faux;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("fauxService")
@Profile("Qa")
public class FauxServiceQaImpl implements FauxService{
    @Override
    public String getDataSourceString() {
        return "QA Datasource URL";
    }
}
