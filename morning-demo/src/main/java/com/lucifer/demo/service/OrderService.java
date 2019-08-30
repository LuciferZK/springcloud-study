package com.lucifer.demo.service;

import com.lucifer.demo.pojo.Order;
import com.lucifer.demo.pojo.Order2;

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

    /**
     * 新增订单
     *
     * @param order
     * @return
     */
    Integer insertOrder(Order2 order);
}
