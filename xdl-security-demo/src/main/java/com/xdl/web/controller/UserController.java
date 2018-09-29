package com.xdl.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xdl.dto.User;
import com.xdl.dto.UserQueryCondition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 *
 * @author xdl
 * @date 2018-09-28
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UsersimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(UserQueryCondition condition, Pageable pageable) {

        log.info(condition.toString());
        log.info(pageable.toString());

        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());

        return list;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户id") @PathVariable String id) {

//        throw new UserNotExistException(id);

        User user = new User();
        user.setUsername("tom");

        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(
                    error -> log.error(error.getDefaultMessage())
            );
        }

        log.info(user.toString());
        user.setId("1");

        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(error -> log.error(error.getDefaultMessage()));
        }

        log.info(user.toString());
        user.setId("1");

        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        log.info(id);
    }

}
