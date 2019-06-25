package com.linfeiyang.shop.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BaseController {

    int getUserId() {
        try {
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                return (int)SecurityContextHolder.getContext().getAuthentication().getCredentials();
            } else {
                throw new BadCredentialsException("请先登录");
            }
        } catch (Exception e) {
            log.error("", e);
            throw new BadCredentialsException("请先登录");
        }

    }

}
