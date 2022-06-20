package com.optum.reboot.azure.cosmosapp.cosmossampleapp;

import com.optum.reboot.azure.cosmosapp.cosmossampleapp.services.RandomDataPushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CosmossampleappApplication implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(CosmossampleappApplication.class);

	@Autowired
	private RandomDataPushService randomDataPushService;

	public static void main(String[] args) {
		SpringApplication.run(CosmossampleappApplication.class, args);
	}

	public void run(String... var1) {
		randomDataPushService.pushData();
	}

}
