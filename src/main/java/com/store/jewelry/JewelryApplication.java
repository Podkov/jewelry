package com.store.jewelry;

import com.store.jewelry.model.Address;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JewelryApplication {

    public static void main(String[] args) {
        SpringApplication.run(JewelryApplication.class, args);
    }

}
