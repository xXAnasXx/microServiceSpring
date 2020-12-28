package org.mrb.inventoryservice;

import org.mrb.inventoryservice.entities.Product;
import org.mrb.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.sql.SQLOutput;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"PS5",5000));
            productRepository.save(new Product(null,"MAC Retina 2019",8500));
            productRepository.save(new Product(null,"Iphone 8",7520));
            productRepository.findAll().forEach(product -> {
                System.out.println(product.toString());
            });
        };
    }

}
