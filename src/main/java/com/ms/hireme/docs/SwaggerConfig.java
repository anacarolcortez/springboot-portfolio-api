package com.ms.hireme.docs;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contact() {
        return new Contact(
                "Ana Cortez",
                "http://github.com/anacarolcortez",
                "anaccortez85@gmail.com");
    }
    private ApiInfoBuilder apiInfo() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Hire Me: The Portfolio API");
        apiInfoBuilder.description("API Rest using Java, Springboot, Validation, Security, DataBase (Postgres), Docker, RabbitMq. \nThe goal is to show what I can develop, as Associate Software Developer (entry level) so I can be hired by your company to join the team =) \nThe API is a show case of my own resume and allows any recruter or tech lead to register and set an interview appointment to get to know me better\nThe endpoint Resume is only a GET. A complete CRUD can be tested using other 2 endpoints: Registration and Interview. \nGet the candidate's id (mine) to use it as parameter to the Resume and Interview endpoints. \nAfter creating an interview request, we'll both receive an e-mail about it.");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;

    }
    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ms.hireme"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}