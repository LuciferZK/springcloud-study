package com.lucifer.morningserviceorder.dao;

import com.lucifer.morningserviceorder.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lucifer
 */
public interface OrderMapper extends JpaRepository<Order,String> {

}
