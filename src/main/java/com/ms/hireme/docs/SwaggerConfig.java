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

        apiInfoBuilder.title("The Portfolio API");
        apiInfoBuilder.description("API Rest using Java, Springboot, Validation, Security, Postgres, Docker, RabbitMq. \nThe API is a metalinguistic resume and allows anyone, like tech leads, to create an interview appointment to get to know the professional better. Get the candidate's id (mine) to use it as parameter to test CRUD actions in Registration and Interview endpoints. After creating an interview request, an e-mail will be sent, through asynchronous communication");
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