package com.example.FinalProjectJSP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.controller")
public class FinalProjectJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectJspApplication.class, args);
	}
}
