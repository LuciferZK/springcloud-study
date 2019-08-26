package com.lucifer.morningserviceproduct.dao;

import com.lucifer.morningserviceproduct.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description:
 */
public interface ProductMapper extends JpaRepository<Product,String> {
}
