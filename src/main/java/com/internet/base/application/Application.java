package com.internet.base.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.internet.base" })
//@EntityScan("com.infotech.model")
//@EnableJpaRepositories("com.infotech.repositoryy")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
