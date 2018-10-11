package com.xdl.security.core.validate.code.sms;

import com.xdl.security.core.properties.SecurityProperties;
import com.xdl.security.core.validate.code.ValidateCode;
import com.xdl.security.core.validate.code.ValidateCodeGenerator;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 *
 * @author xdl
 * @date 2018-10-11
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    @Getter
    @Setter
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }

}
