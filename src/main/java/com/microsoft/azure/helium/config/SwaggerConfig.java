package com.microsoft.azure.helium.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .select()
            .apis(RequestHandlerSelectors.basePackage("com.microsoft.azure.helium"))
            .paths(PathSelectors.any())
            .build()
          .apiInfo(apiInfo());                 
    }

    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Helium", 
          "A Java reference app for bootstrapping your next Web Apps for Containers service", 
          "1.0.0", 
          "Terms of service", 
          new Contact("John Doe", "www.example.com", "myeaddress@company.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }
}