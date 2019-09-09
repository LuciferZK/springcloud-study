package com.lucifer.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lucifer.demo.pojo.Order;
import com.lucifer.demo.pojo.OrderDemo;

import java.util.List;

/**
 * @author Lucifer
 */
public interface OrderDemoMapper extends BaseMapper<OrderDemo> {
    /**
     * 查询所有
     *
     * @return
     */
    List<Order> selectAll();

}
