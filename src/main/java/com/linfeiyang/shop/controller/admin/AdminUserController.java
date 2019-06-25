package com.linfeiyang.shop.controller.admin;

import com.linfeiyang.shop.annotation.AdminController;
import com.linfeiyang.shop.bean.ResultBean;
import com.linfeiyang.shop.bean.ResultListBean;
import com.linfeiyang.shop.mybatis.mapper.AdminMapper;
import com.linfeiyang.shop.mybatis.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@AdminController
@Slf4j
public class AdminUserController {

    @Resource
    private AdminMapper adminMapper;

    @GetMapping("/users")
    public ResultListBean<Admin> users(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        List<Admin> users = adminMapper.selectUsers((page - 1) * size, size);
        return ResultListBean.ok(users);
    }

    @PutMapping("/users")
    public ResultBean<Boolean> updateProduct(@RequestBody Admin admin) {
        Integer id = admin.getId();
        Assert.isTrue(id != null, "参数错误");
        boolean ret = adminMapper.updateByPrimaryKey(admin) > 0;
        return ResultBean.ok(ret);
    }

    @DeleteMapping("/users/{id}")
    public ResultBean<Boolean> deleteProduct(@PathVariable Integer id) {
        boolean ret = adminMapper.deleteByPrimaryKey(id) > 0;
        return ResultBean.ok(ret);
    }

    @PostMapping("/users")
    public ResultBean<Boolean> addProduct(@RequestBody Admin admin) {
        boolean ret = adminMapper.insert(admin) > 0;
        return ResultBean.ok(ret);
    }

}
