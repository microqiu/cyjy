package com.linfeiyang.shop.service.admin;

import com.linfeiyang.shop.config.security.PasswordEncoder;
import com.linfeiyang.shop.mybatis.mapper.AdminMapper;
import com.linfeiyang.shop.mybatis.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@Slf4j
@Service
public class AdminAuthService {

    private final PasswordEncoder passwordEncoder;

    @Resource
    private AdminMapper adminMapper;

    @Autowired
    public AdminAuthService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Authentication login(String userName, String password) {
        if (StringUtils.isAnyBlank(userName, password)) {
            throw new BadCredentialsException("用户名和密码不能为空!");
        }
        Admin admin = adminMapper.selectByUserName(userName);
        if (admin == null) {
            throw new BadCredentialsException("找不到此用户!");
        }
        if (!passwordEncoder.validate(password, admin.getPassword())) {
            throw new BadCredentialsException("密码不正确!");
        }
        return new UsernamePasswordAuthenticationToken(userName, admin.getId());
    }

    public Admin validateCurrentUser() {
        Admin currentUser = getCurrentUser();
        Assert.notNull(currentUser, "未登录");
        return currentUser;
    }

    private Admin getCurrentUser() {
        try {
            Integer id = (Integer) SecurityContextHolder.getContext().getAuthentication().getCredentials();
            if (id == null || id <= 0) return null;
            return adminMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            return null;
        }
    }

    public void updateAdmin(Admin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    public boolean addAdmin(Admin admin) {
        admin.setCreateTime((int) (System.currentTimeMillis() / 1000));
        admin.setUpdateTime((int) (System.currentTimeMillis() / 1000));
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminMapper.insertSelective(admin) > 0;
    }
}
