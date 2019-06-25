package com.linfeiyang.shop.config;

import com.linfeiyang.shop.bean.ResultBean;
import com.linfeiyang.shop.common.GsonUtils;
import com.linfeiyang.shop.common.NetUtils;
import com.linfeiyang.shop.mybatis.model.Admin;
import com.linfeiyang.shop.service.admin.AdminAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Resource
    private AdminAuthService adminAuthService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        BufferedReader br = null;
        try {
            br = request.getReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = null;
        StringBuilder wholeStr = new StringBuilder();
        while(true){
            try {
                if ((str = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            wholeStr.append(str);
        }
        System.out.println(wholeStr);
        Admin admin = GsonUtils.toObject(wholeStr.toString(), Admin.class);
        this.setUsernameParameter(admin.getUsername());
        this.setPasswordParameter(admin.getPassword());
        return super.attemptAuthentication(request, response);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        List<String> authorities = new ArrayList<>();
        authResult.getAuthorities().forEach(item -> authorities.add(item.getAuthority()));
        response.setStatus(200);
        response.setHeader("content-type", "text/json;charset=UTF-8");
        response.getOutputStream().write(GsonUtils.toJson(ResultBean.ok(authResult.getName())).getBytes(StandardCharsets.UTF_8));
        response.getOutputStream().flush();
        successHandler(request);
    }

    private void successHandler(HttpServletRequest request) {
        Admin admin = adminAuthService.validateCurrentUser();
        Admin adminUpdate = new Admin();
        adminUpdate.setId(admin.getId());
        String ipAddress = NetUtils.getIpAddress(request);
        adminUpdate.setLastTime((int) (System.currentTimeMillis() / 1000));
        adminUpdate.setLastIp(ipAddress);
        adminAuthService.updateAdmin(adminUpdate);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        ResultBean<Integer> resultBean = new ResultBean<>(400, failed.getMessage(), 0);
        response.setStatus(200);
        response.setHeader("content-type", "text/json;charset=UTF-8");
        response.getOutputStream().write(GsonUtils.toJson(resultBean).getBytes(StandardCharsets.UTF_8));
        //super.unsuccessfulAuthentication(request, response, failed);
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return this.getPasswordParameter();
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return this.getUsernameParameter();
    }
}
