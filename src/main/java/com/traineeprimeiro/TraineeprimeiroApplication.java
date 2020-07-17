package com.traineeprimeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
    "com.traineeprimeiro.controllers",
        "com.traineeprimeiro.domain.services",
        "com.traineeprimeiro.infra.data"
})
@EnableJpaRepositories("com.traineeprimeiro.infra.repositorys")
@EntityScan("com.traineeprimeiro.domain.entities")
@SpringBootApplication
public class TraineeprimeiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraineeprimeiroApplication.class, args);
    }

}
