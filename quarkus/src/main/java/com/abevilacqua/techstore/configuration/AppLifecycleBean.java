package com.abevilacqua.techstore.configuration;

import com.abevilacqua.techstore.model.Product;
import com.abevilacqua.techstore.repository.ProductRepo;
import io.quarkus.runtime.StartupEvent;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.stream.Stream;

@ApplicationScoped
@NoArgsConstructor
public class AppLifecycleBean {

    private static final Logger LOGGER = LoggerFactory.getLogger("Listener bean");

    private ProductRepo productRepo;

    @Inject
    public AppLifecycleBean(ProductRepo productRepo) { this.productRepo = productRepo; }

    void onStart(@Observes StartupEvent event) {
        LOGGER.info("Application starting...");
        createDB();
    }

    private void createDB() {
        Stream.of(new Product(1, "Mouse", "Really good mouse", 20),
                new Product(2, "Notebook", "Great notebook", 1000),
                new Product(3, "Keyboard", "Great keyboard", 300),
                new Product(4, "Headphones", "Great headphones", 60),
                new Product(5, "Touchscreen", "Great screen", 500))
                .forEach(productRepo::addProduct);
    }
}
