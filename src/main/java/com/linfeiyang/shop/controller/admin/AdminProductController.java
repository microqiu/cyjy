package com.linfeiyang.shop.controller.admin;

import com.linfeiyang.shop.annotation.AdminController;
import com.linfeiyang.shop.bean.ResultBean;
import com.linfeiyang.shop.bean.ResultListBean;
import com.linfeiyang.shop.mybatis.mapper.ProductMapper;
import com.linfeiyang.shop.mybatis.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@AdminController
@Slf4j
public class AdminProductController {

    @Resource
    private ProductMapper productMapper;

    @GetMapping("/products")
    public ResultListBean<Product> products(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        List<Product> productList = productMapper.selectProduct((page - 1) * size, size);
        return ResultListBean.ok(productList);
    }

    @PutMapping("/products")
    public ResultBean<Boolean> updateProduct(@RequestBody Product product) {
        Integer id = product.getId();
        Assert.isTrue(id != null, "参数错误");
        boolean ret = productMapper.updateByPrimaryKey(product) > 0;
        return ResultBean.ok(ret);
    }

    @DeleteMapping("/products/{id}")
    public ResultBean<Boolean> deleteProduct(@PathVariable Integer id) {
        boolean ret = productMapper.deleteByPrimaryKey(id) > 0;
        return ResultBean.ok(ret);
    }

    @PostMapping("/products")
    public ResultBean<Boolean> addProduct(@RequestBody Product product) {
        boolean ret = productMapper.insert(product) > 0;
        return ResultBean.ok(ret);
    }

}
