package com.lucifer.demo.service.impl;

import com.lucifer.demo.dao.OrderMapper;
import com.lucifer.demo.pojo.Order;
import com.lucifer.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/30
 * @description:
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;


    @Override
    public List<Order> orderQueryAll() {
        return orderMapper.selectAll();
    }
}
