package com.xdl.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全配置
 *
 * @author xdl
 * @date 2018-10-10
 */
@ConfigurationProperties(prefix = "xdl.security")
@Data
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

}
