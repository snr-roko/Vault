package com.rokoinc.Vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class VaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	@Scheduled(fixedRate = 30, timeUnit = TimeUnit.SECONDS)
	public void displayApplicationName() throws InterruptedException {
		System.out.println("*************************Vault*************************");
		Thread.sleep(5000);
		System.out.println("New Features Coming");
	}

}
