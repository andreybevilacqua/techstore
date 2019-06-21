package com.abevilacqua.techstore.configuration;

import com.abevilacqua.techstore.model.Product;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.util.stream.Stream;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOGGER = LoggerFactory.getLogger("Listener bean");

    @Transactional
    void onStart(@Observes StartupEvent event) {
        LOGGER.info("Application starting...");
        createDB();
    }

    private void createDB() {
        Stream.of(new Product("Mouse", "Really good mouse", 20),
                new Product("Notebook", "Great notebook", 1000),
                new Product("Keyboard", "Great keyboard", 300),
                new Product("Headphones", "Great headphones", 60),
                new Product( "Touchscreen", "Great screen", 500))
                .forEach(product -> product.persist());
        System.out.println(Product.findAll());
    }
}
