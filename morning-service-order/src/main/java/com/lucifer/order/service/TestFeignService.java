package com.lucifer.order.service;

import com.lucifer.product.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/27
 * @description:
 */
@FeignClient(value = "morning-service-product")
public interface TestFeignService {

    /**
     * 利用feign测试order服务调用product服务
     *
     * @return
     */
    @GetMapping(value = "productQueryAll")
    String testFeign();

}
