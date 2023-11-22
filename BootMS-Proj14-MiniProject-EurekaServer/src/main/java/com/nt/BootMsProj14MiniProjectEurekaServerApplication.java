package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj14MiniProjectEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj14MiniProjectEurekaServerApplication.class, args);
	}

}
