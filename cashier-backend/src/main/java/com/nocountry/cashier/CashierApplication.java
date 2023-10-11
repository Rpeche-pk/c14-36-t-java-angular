package com.nocountry.cashier;

import com.nocountry.cashier.config.FirebaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FirebaseProperties.class)
public class CashierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashierApplication.class, args);
	}

}
