package edu.lits.maliatko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = { "edu.lits.maliatko.controller" } )
@EnableSwagger2
public class MalytkoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MalytkoApplication.class, args);
	}

}





