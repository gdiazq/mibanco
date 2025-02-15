package com.mibanco.mcsv_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
@SpringBootApplication
public class McsvAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvAuthApplication.class, args);
	}

}
