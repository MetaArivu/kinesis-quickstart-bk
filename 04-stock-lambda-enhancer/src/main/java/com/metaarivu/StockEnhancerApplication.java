package com.metaarivu;

import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockEnhancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockEnhancerApplication.class, args);
	}

	@Bean
	public Supplier<String> getMessage() {
		return () -> "Welcome to Spring Server Less Demo!!!";
	}
}
