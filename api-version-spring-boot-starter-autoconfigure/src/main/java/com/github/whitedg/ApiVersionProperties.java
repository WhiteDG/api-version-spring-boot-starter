package com.github.whitedg;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author White
 */
@ConfigurationProperties(prefix = "api-version")
public class ApiVersionProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
