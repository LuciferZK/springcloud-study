package com.lucifer.morningserviceorder.controller;

import com.lucifer.common.utils.CommonResult;
import com.lucifer.morningserviceorder.pojo.Order;
import com.lucifer.morningserviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/26
 * @description:
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "orderQueryAll")
    public CommonResult<List<Order>> queryAll() {
        List<Order> products = orderService.orderQueryAll();
        return CommonResult.success(products);
    }

    @Value(value = "${defaultName}")
    private String defaultName;

    @GetMapping("test")
    public String test(){
        return defaultName;
    }


}
