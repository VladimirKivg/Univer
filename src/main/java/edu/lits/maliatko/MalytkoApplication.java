package edu.lits.maliatko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "edu.lits.maliatko.controller" } )
public class MalytkoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MalytkoApplication.class, args);
	}

}





