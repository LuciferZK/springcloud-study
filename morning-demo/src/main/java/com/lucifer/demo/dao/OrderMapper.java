package com.lucifer.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lucifer.demo.pojo.Order;
import com.lucifer.demo.pojo.Order2;

import java.util.List;

/**
 * @author Lucifer
 */
public interface OrderMapper extends BaseMapper<Order2> {
    /**
     * 查询所有
     *
     * @return
     */
    List<Order> selectAll();

}
