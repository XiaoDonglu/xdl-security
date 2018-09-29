package com.xdl.validator;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义验证注解逻辑
 *
 * @author xdl
 * @date 2018-09-28
 */
@Slf4j
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Override
    public void initialize(MyConstraint myConstraint) {
        log.info("My validator init.");
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        log.info(object.toString());
        return false;
    }
}
