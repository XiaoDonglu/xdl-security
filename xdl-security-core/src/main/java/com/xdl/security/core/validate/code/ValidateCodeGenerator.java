package com.xdl.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 *
 * @author xdl
 * @date 2018-10-10
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);

}
