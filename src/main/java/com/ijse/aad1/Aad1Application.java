package com.ijse.aad1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration - mark this as a configuration class
//@EnableAutoConfiguration - enable autoconfiguration
//@ComponentScan - scan for components in the current package and sub-packages
@SpringBootApplication
public class Aad1Application {

	public static void main(String[] args) {
		SpringApplication.run(Aad1Application.class, args);
	}

}
