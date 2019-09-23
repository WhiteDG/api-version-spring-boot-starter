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

package com.github.whitedg;

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
