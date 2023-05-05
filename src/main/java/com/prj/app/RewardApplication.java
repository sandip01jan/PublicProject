package com.prj.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.prj.app.controller", "com.prj.app.service", "com.prj.app.repository"})
public class RewardApplication {
	public static void main(String[] args) {
		SpringApplication.run(RewardApplication.class, args);
	}
}