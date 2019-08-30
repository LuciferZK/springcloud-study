package com.lucifer.demo.service;

import com.lucifer.demo.pojo.Order;

import java.util.List;

/**
 * @author Lucifer
 */
public interface OrderService {


    /**
     * 查询所有订单
     *
     * @return
     */
    List<Order> orderQueryAll();
}
