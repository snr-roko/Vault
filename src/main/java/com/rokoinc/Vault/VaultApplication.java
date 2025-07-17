package com.rokoinc.Vault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class VaultApplication {

	private final Logger logger = LoggerFactory.getLogger(VaultApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	@Scheduled(fixedRate = 30, timeUnit = TimeUnit.SECONDS)
	public void displayApplicationName() throws InterruptedException {
		logger.info("*************************Vault*************************");
		Thread.sleep(5000);
		logger.info("New Features Coming");
	}
}
