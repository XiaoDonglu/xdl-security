package com.xdl.security.core.properties;

import lombok.Data;

/**
 * 图形验证码配置
 *
 * @author xdl
 * @date 2018-10-10
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {

    private int width = 67;
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }

}
