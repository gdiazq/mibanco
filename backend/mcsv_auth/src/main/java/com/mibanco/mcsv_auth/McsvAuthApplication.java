package com.mibanco.mcsv_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import com.mibanco.mcsv_auth.config.JwtProperties;

@Configuration
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.mibanco.mcsv_auth")
@EnableConfigurationProperties(JwtProperties.class)
public class McsvAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvAuthApplication.class, args);
	}

}
