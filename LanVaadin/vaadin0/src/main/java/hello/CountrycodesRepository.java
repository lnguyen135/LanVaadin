package hello;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//import com.atasia.travel.ent.Countrycode;

public interface CountrycodesRepository extends CrudRepository<Countrycodes, Long> {
}
