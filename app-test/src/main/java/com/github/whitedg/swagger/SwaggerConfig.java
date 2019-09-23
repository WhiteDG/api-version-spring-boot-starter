/*
 * Copyright 2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
