package pl.arkadiuszsas.eXperience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application returns the name of the last modified requested user's GitHub repository.
 * 
 * @author	Arkadiusz Sas
 * @version	1.0
 */
@SpringBootApplication
public class EXperienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EXperienceApplication.class, args);
	}

}
