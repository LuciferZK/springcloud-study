package com.lucifer.morningserviceproduct.pojo;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description: 商品实体类
 */
@Data
@Entity
@Table(name = "product_info")
//@TableName(value = "product_info")
public class Product {

    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    //@TableField(value = "product_id")
    private int productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    //@TableField(value = "product_name")
    private String productName;


    /**
     * 单价
     */
    @Column(name = "product_price")
    //@TableField(value = "product_price")
    private BigDecimal productPrice;

    /**
     * 库存
     */
    @Column(name = "product_stock")
   // @TableField(value = "product_stock")
    private Integer productStock;

    /**
     * 商品描述
     */
    @Column(name = "product_description")
   // @TableField(value = "product_description")
    private String productDescription;


    /**
     * 小图
     */
    @Column(name = "product_icon")
    //@TableField(value = "product_icon")
    private String productIcon;


    /**
     * 商品状态,0正常1下架
     */
    @Column(name = "product_status")
    //@TableField(value = "product_status")
    private Integer productStatus;


    /**
     * 类目编号
     */
    @Column(name = "category_type")
    //@TableField(value = "category_type")
    private Integer categoryType;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    //@TableField(value = "create_time")
    private Timestamp createTime;


    /**
     * 修改时间
     */
    @Column(name = "update_time")
   // @TableField(value = "update_time")
    private Timestamp updateTime;


}
