package com.xdl.security.core.properties;

import lombok.Data;

/**
 * 验证码配置
 *
 * @author xdl
 * @date 2018-10-10
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

}
