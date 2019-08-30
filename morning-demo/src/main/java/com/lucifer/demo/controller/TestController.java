package com.lucifer.demo.controller;

import com.lucifer.common.utils.CommonResult;
import com.lucifer.demo.pojo.Order;
import com.lucifer.demo.service.OrderService;
import com.lucifer.demo.util.excel.ExportExcelUtils;
import com.lucifer.demo.util.excel.ImportExcelUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/28
 * @description:
 */
@RestController
public class TestController {

    @Resource
    private OrderService orderService;

    @PostMapping(value = "testImportExcel")
    public CommonResult<List<Object>> testImportExcel(HttpServletRequest httpServletRequest) throws IOException {
        List<Object> objects = ImportExcelUtils.saxReadListStringV2007(httpServletRequest);
        return CommonResult.success(objects);
    }

    @GetMapping(value = "testExportExcel")
    public CommonResult<List<Object>> testExportExcel() throws IOException {
        List<Order> orders = orderService.orderQueryAll();
        ExportExcelUtils.writeV2007(orders, Order.class);
        return CommonResult.success(null);
    }


}