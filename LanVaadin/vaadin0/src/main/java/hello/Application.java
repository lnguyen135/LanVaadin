

package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import com.atasia.travel.ent.Citycode;
//import com.atasia.travel.ent.Countrycode;
//import com.atasia.travel.ent.Customer;

@SpringBootApplication

@EntityScan(basePackages="hello")
@EnableJpaRepositories("hello")
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CountrycodesRepository repository) {
		return (args) -> {
			Countrycodes aCd = new Countrycodes();
			//aCd.setCountry_ID(5);
			aCd.setCountry_Name("Thailand");;
			aCd.setHtml_Description("http://www.countryreports.org/country/Thailand.htm");;
			aCd.getImage();
			aCd.setText_Description("Thailand is a Southeast Asian country. It's known for tropical beaches, opulent royal palaces, ancient ruins and ornate temples displaying figures of Buddha.");
		
		
			
			//repository.save(aCd);
				
	
			// fetch all customers
			log.info("country code found with findAll():");
			log.info("-------------------------------");
			for (Countrycodes c : repository.findAll()) {
				//log.info("country code: " + c.getCountry_Name());
				log.info("country code: " + c.getCountry_ID());
				log.info("country code: " + c.getCountry_Name());
			log.info("country code: " + c.getText_Description());
				log.info("country code: " + c.getHtml_Description());
				
			
				
				
			}
		};
	

			
	}
			
	}
			

