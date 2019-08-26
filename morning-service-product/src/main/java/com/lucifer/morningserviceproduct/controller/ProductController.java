package com.lucifer.morningserviceproduct.controller;

import com.lucifer.common.utils.CommonResult;
import com.lucifer.morningserviceproduct.pojo.Product;
import com.lucifer.morningserviceproduct.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description: 测试
 */
@RestController
//@RequestMapping(value = "product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping(value = "productQueryAll")
    public CommonResult<List<Product>> queryAll() {
        List<Product> products = productService.productQueryAll();
        return CommonResult.success(products);
    }
}
