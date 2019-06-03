package com.abevilacqua.techstore;

import com.abevilacqua.techstore.model.Product;
import com.abevilacqua.techstore.repository.ProductRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class TechstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechstoreApplication.class, args);
	}

	@Bean
	public ApplicationRunner run(ProductRepo productRepo) {
		return args -> {
			Stream.of(
					new Product(1, "Mouse", "Really good mouse", 20),
					new Product(2, "Notebook", "Great notebook", 1000))
					.forEach(productRepo::addProduct);
		};
	}

}
