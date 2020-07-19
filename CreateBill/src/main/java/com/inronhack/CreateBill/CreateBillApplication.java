package com.inronhack.CreateBill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CreateBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateBillApplication.class, args);
	}

}
