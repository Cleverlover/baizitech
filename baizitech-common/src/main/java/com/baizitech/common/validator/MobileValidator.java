package com.baizitech.common.validator;

import com.baizitech.common.annotation.IsMobile;
import com.baizitech.common.entity.RegexpConstant;
import com.baizitech.common.utils.BaizitechUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhengwei.chen
 * @date 2021/4/28 11:11
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return BaizitechUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}