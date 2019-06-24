package com.linfeiyang.shop.controller;

import com.linfeiyang.shop.mybatis.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestController {


    @Resource
    private AdminMapper adminMapper;

    @GetMapping("/test")
    public Object testMysql() {
        return adminMapper.selectByPrimaryKey(1);
    }


}
