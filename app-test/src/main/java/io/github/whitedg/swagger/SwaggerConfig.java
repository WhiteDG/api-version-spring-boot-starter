package io.github.whitedg.swagger;

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
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        return docket.apiInfo(apiInfoDev())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cc.white.starter.web"))
                .paths(PathSelectors.any())
                .build()
                .enable(true);
    }

    private ApiInfo apiInfoDev() {
        return new ApiInfoBuilder()
                .title("api-version-test doc")
                .description("api-version-test")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
