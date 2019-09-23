package com.github.whitedg.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerAll() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        return docket.apiInfo(apiInfo("all"))
                .groupName("all")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.whitedg.web"))
                .paths(PathSelectors.any())
                .build()
                .enable(true);
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
                .title("api-version-test doc")
                .description("api-version-test")
                .termsOfServiceUrl("")
                .version(version)
                .build();
    }

    @Bean
    public Docket swaggerV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.whitedg.web"))
                .paths(PathSelectors.regex("/v1.*"))
                .build()
                .apiInfo(apiInfo("v1"));
    }

    @Bean
    public Docket swaggerV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.whitedg.web"))
                .paths(PathSelectors.regex("/v2.*"))
                .build()
                .apiInfo(apiInfo("v2"));
    }

}
