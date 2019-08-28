package com.lucifer.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lucifer.order.pojo.Order;

import java.util.List;

/**
 * @author Lucifer
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 查询所有订单
     *
     * @return
     */
    List<Order> selectAll();
}
