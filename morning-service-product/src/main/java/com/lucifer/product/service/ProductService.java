package com.lucifer.product.service;

import com.lucifer.product.pojo.Product;

import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description:
 */
public interface ProductService {
    /**
     * 查询所有商品
     *
     * @return
     */
    List<Product> productQueryAll();
}
