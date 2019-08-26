package com.lucifer.morningserviceproduct.service.impl;

import com.lucifer.morningserviceproduct.dao.ProductMapper;
import com.lucifer.morningserviceproduct.pojo.Product;
import com.lucifer.morningserviceproduct.service.ProductService;
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
        return productMapper.findAll();
    }
}
