package com.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestJewelleryShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestJewelleryShopApplication.class, args);
	}
	// configure ModelMapper as a spring bean
		// equivalent to <bean> tag in xml file
		@Bean
		public ModelMapper mapper() {
			
			return new ModelMapper();
		}
}
