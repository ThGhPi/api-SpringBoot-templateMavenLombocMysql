package fr.afpa.brive.cda.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // enables component scanning, autoconfiguration, and others that I don't know about.
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	} // entry point of the Spring Boot Application

}
