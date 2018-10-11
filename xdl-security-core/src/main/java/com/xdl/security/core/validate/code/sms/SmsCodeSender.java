package com.xdl.security.core.validate.code.sms;

/**
 * 短信发送接口
 *
 * @author xdl
 * @date 2018-10-11
 */
public interface SmsCodeSender {

    void send(String mobile, String code);

}
