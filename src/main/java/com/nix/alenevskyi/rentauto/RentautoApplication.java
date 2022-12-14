package com.nix.alenevskyi.rentauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class RentautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentautoApplication.class, args);
	}

}
