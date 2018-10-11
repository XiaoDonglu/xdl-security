package com.xdl.security.core.properties;

import lombok.Data;

/**
 * 短信验证码配置
 *
 * @author xdl
 * @date 2018-10-11
 */
@Data
public class SmsCodeProperties {

    private int length = 6;
    /**
     * 失效时间
     */
    private int expireIn = 60;
    /**
     * 过滤url
     */
    private String url;

}
