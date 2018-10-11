package com.xdl.security.core.properties;

import lombok.Data;

/**
 * 图形验证码配置
 *
 * @author xdl
 * @date 2018-10-10
 */
@Data
public class ImageCodeProperties {

    private int width = 67;
    private int height = 23;
    private int length = 4;
    /**
     * 失效时间
     */
    private int expireIn = 60;
    /**
     * 过滤url
     */
    private String url;

}
