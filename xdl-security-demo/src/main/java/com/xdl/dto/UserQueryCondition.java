package com.xdl.dto;

import lombok.Data;

/**
 * 用户查询
 *
 * @author xdl
 * @date 2018-09-28
 */
@Data
public class UserQueryCondition {

    private String username;

    private int age;

    private int ageTo;
}
