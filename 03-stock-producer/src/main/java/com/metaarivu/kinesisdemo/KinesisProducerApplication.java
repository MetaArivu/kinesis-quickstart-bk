package com.metaarivu.kinesisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KinesisProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinesisProducerApplication.class, args);
	}

}
