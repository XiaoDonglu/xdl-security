package com.xdl.code;

import com.xdl.security.core.validate.code.ValidateCodeGenerator;
import com.xdl.security.core.validate.code.image.ImageCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 图形验证码生成器
 *
 * @author xdl
 * @date 2018-10-10
 */
//@Component("imageValidateCodeGenerator")
@Slf4j
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        log.info("更高级的图形验证码生成代码");
        return null;
    }

}