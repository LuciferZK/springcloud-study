package com.lucifer.order.service.impl;

import com.lucifer.order.dao.OrderMapper;
import com.lucifer.order.pojo.Order;
import com.lucifer.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/26
 * @description:
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> orderQueryAll() {
        return orderMapper.selectAll();
    }
}
