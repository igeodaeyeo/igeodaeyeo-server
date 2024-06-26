package com.igdy.igeodaeyeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IgeodaeyeoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgeodaeyeoApplication.class, args);
    }

}
