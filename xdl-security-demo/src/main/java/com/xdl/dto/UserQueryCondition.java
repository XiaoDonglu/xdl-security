package com.xdl.dto;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "用户年龄起始值")
    private int age;

    @ApiModelProperty(value = "用户年龄终止值")
    private int ageTo;
}
