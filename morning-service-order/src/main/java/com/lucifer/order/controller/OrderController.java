package com.lucifer.order.controller;

import com.lucifer.common.utils.CommonResult;
import com.lucifer.order.pojo.Order;
import com.lucifer.order.service.OrderService;
import com.lucifer.order.service.TestFeignService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/26
 * @description:
 */
@RefreshScope
@EnableFeignClients(basePackages = "com.lucifer.order")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private TestFeignService testFeignService;

    @GetMapping(value = "orderQueryAll")
    public CommonResult<List<Order>> queryAll() {
        List<Order> orders = orderService.orderQueryAll();
        return CommonResult.success(orders);
    }

    @GetMapping(value = "testFeign")
    public CommonResult<String> testFeign(){
        String str = testFeignService.testFeign();
        return CommonResult.success(str);
    }

}
