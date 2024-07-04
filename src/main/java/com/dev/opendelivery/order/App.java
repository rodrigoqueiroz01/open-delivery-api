package com.dev.opendelivery.order;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		links();
	}

	private static void links() {
		log.info("Swagger UI: http://localhost:8080/swagger-ui/index.html");
		log.info("Application: http://localhost:8080/order/OrderApplication");
	}

}
