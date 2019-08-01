package io.github.whitedg;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author White
 */
public class ApiVersionWebMvcRegistrations implements WebMvcRegistrations {

    private ApiVersionProperties apiVersionProperties;

    public ApiVersionWebMvcRegistrations(ApiVersionProperties apiVersionProperties) {
        this.apiVersionProperties = apiVersionProperties;
    }

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiVersionRequestMappingHandlerMapping(StringUtils.isEmpty(apiVersionProperties.getPrefix()) ?
                "v" : apiVersionProperties.getPrefix(), apiVersionProperties.getSuffix());
    }

}
