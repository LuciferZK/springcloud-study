package com.lucifer.order.service;

import com.lucifer.order.pojo.Order;

import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/26
 * @description:
 */
public interface OrderService {

    /**
     * 查询所有订单
     *
     * @return
     */
    List<Order> orderQueryAll();
}
