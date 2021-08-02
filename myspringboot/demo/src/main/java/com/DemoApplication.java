//package com.example.demo;
package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.day.control"})
public class DemoApplication {

	public static void main(String[] args) {
		// 스프링 컨테이너 구동.
		SpringApplication.run(DemoApplication.class, args);
	}
}
