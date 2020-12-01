package com.hana.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class HanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HanaApplication.class, args);
	}

}
