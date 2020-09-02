package com.cg.scheduledprogramservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableEurekaClient
public class ScheduledProgramServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledProgramServiceApplication.class, args);

	}

	@Bean
	public Docket SwaggerCongiguration() {
		// here we need to create instance of docket to user swagger2 documentation

		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.cg.scheduledprogramservice")).build()
				.apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Schedule Service Api", "Api for university Admission System", "1.0",
				"Api end points for crud operation",
				new springfox.documentation.service.Contact("Asutosh Panda", "asutosh8093@gmail.com", "www.google.com"),
				"Capgemini BootCamp Training", "using swagger for documentation", Collections.emptyList());
	}

}
