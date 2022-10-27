package com.nix.alenevskyi.rentauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RentautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentautoApplication.class, args);
	}

}
