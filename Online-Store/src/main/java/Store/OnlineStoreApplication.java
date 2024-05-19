package Store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
// This annotation indicates that this class is the main Spring Boot application class
@SpringBootApplication
public class OnlineStoreApplication {

    // The main method is the entry point of the application
	public static void main(String[] args) {
        // This line starts the Spring Boot application
		SpringApplication.run(OnlineStoreApplication.class, args);
	}

}
