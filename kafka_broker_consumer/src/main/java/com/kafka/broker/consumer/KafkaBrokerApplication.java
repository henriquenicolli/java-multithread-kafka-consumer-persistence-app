package com.kafka.broker.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.kafka.broker.consumer" })
@SpringBootApplication
public class KafkaBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBrokerApplication.class, args);
	}

}
