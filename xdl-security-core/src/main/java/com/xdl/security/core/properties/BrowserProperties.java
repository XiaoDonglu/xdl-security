package com.xdl.security.core.properties;

import lombok.Data;


/**
 * 浏览器配置
 *
 * @author xdl
 * @date 2018-10-10
 */
@Data
public class BrowserProperties {

    private String loginPage = "/xdl-signIn.html";

    private LoginType loginType = LoginType.JSON;
}
