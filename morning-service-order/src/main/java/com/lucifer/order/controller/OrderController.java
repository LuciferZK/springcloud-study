package com.lucifer.order.controller;

import com.lucifer.common.utils.CommonResult;
import com.lucifer.order.pojo.Order;
import com.lucifer.order.service.OrderService;
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

    /**
     * 用于测试读取github配置文件属性值
     */
    @Value(value = "${env}")
    private String env;

    @GetMapping("test")
    public String test(){
        return env;
    }


}
