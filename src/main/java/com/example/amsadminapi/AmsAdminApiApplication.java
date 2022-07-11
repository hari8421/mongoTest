package com.example.amsadminapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableMongoRepositories
@OpenAPIDefinition(info= @Info(title="Article Management System"))
public class AmsAdminApiApplication {

	public static void main(String[] args) {
		System.setProperty("javax.net.ssl.trustStore", "NUL");
		System.setProperty("javax.net.ssl.trustStoreType", "Windows-ROOT");
		SpringApplication.run(AmsAdminApiApplication.class, args);
	}

}
