package com.lucifer.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lucifer.product.dao.ProductMapper;
import com.lucifer.product.pojo.Product;
import com.lucifer.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description:
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> productQueryAll() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        return productMapper.selectList(queryWrapper);
    }
}
