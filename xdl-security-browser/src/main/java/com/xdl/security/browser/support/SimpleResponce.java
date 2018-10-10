package com.xdl.security.browser.support;

import lombok.Data;

/**
 * 简单响应
 *
 * @author xdl
 * @date 2018-10-10
 */
@Data
public class SimpleResponce {

    private Object content;

    public SimpleResponce(Object content) {
        this.content = content;
    }
}
