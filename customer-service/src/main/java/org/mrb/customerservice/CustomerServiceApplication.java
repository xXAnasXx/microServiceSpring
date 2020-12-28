package org.mrb.customerservice;

import org.mrb.customerservice.entities.Customer;
import org.mrb.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null,"Abouzakaria","abouzakaria@gmail.com"));
            customerRepository.save(new Customer(null,"Anass","anass@gmail.com"));
            customerRepository.save(new Customer(null,"Mohamed","med@@gmail.com"));
            customerRepository.save(new Customer(null,"Maria","maria@gmail.com"));
            customerRepository.findAll().forEach(
                    customer -> {System.out.println(customer.toString());
                    });
        };
    }

}
