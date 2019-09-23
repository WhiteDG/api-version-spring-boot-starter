package com.github.whitedg;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author White
 */
@ConditionalOnWebApplication
@Configuration
@EnableConfigurationProperties(ApiVersionProperties.class)
public class ApiVersionAutoConfiguration {

    @Bean
    public ApiVersionWebMvcRegistrations webMvcRegistrationsConfig(ApiVersionProperties apiVersionProperties) {
        return new ApiVersionWebMvcRegistrations(apiVersionProperties);
    }
}
