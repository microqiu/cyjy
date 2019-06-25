package com.linfeiyang.shop.controller.admin;

import com.linfeiyang.shop.annotation.AdminController;
import com.linfeiyang.shop.bean.ResultListBean;
import com.linfeiyang.shop.mybatis.mapper.OrderMapper;
import com.linfeiyang.shop.mybatis.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@AdminController
@Slf4j
public class AdminOrderController {

    @Resource
    private OrderMapper orderMapper;

    @GetMapping("/orders")
    public ResultListBean<Order> orders(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        List<Order> ret = orderMapper.selectOrders((page - 1) * size, size);
        return ResultListBean.ok(ret);
    }


}
