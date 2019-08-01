package cc.white.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author White
 */
@ConfigurationProperties(prefix = "api-version")
public class ApiVersionProperties {

    private boolean enable;
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
