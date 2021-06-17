package ch.bbzw.shoeStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShoeStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoeStoreApplication.class, args);
	}

}
