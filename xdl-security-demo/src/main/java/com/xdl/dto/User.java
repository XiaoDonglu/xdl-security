package com.xdl.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.xdl.validator.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 用户
 *
 * @author xdl
 * @date 2018-09-28
 */
@Data
public class User {

    public interface UsersimpleView {
    }


    public interface UserDetailView extends UsersimpleView {
    }

    @MyConstraint(message = "自定义注解不通过")
    @JsonView(UsersimpleView.class)
    private String id;

    @JsonView(UsersimpleView.class)
    private String username;

    @NotBlank(message = "密码不能为空")
    @JsonView(UserDetailView.class)
    private String password;

    @Past(message = "生日必须为过去的时间")
    @JsonView(UsersimpleView.class)
    private Date birthday;
}
