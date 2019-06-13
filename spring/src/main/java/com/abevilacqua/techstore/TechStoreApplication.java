package com.abevilacqua.techstore;

import com.abevilacqua.techstore.model.Product;
import com.abevilacqua.techstore.repository.ProductRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class TechStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechStoreApplication.class, args);
	}

	@Bean
	public ApplicationRunner run(ProductRepo productRepo) {
		return args -> {
			Stream.of(
					new Product(1, "Mouse", "Really good mouse", 20),
					new Product(2, "Notebook", "Great notebook", 1000),
					new Product(3, "Keyboard", "Great keyboard", 300),
					new Product(4, "Headphones", "Great headphones", 60),
					new Product(5, "Touchscreen", "Great screen", 500))
					.forEach(productRepo::addProduct);
		};
	}

}
