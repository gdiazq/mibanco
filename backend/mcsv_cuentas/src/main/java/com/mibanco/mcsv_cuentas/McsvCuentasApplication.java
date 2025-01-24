package com.mibanco.mcsv_cuentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class McsvCuentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvCuentasApplication.class, args);
	}

}
