package com.mibanco.mcsv_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// Habilita el servidor Eureka
@EnableEurekaServer
@SpringBootApplication
public class McsvEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvEurekaApplication.class, args);
	}

}
