package com.example.histrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
@EnableHystrixDashboard
@SpringBootApplication
public class HistrixdashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistrixdashboardApplication.class, args);
	}

}
