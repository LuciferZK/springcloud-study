package com.lucifer.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lucifer.demo.pojo.Order;

import java.util.List;

/**
 * @author Lucifer
 */
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 查询所有
     *
     * @return
     */
    List<Order> selectAll();

}
