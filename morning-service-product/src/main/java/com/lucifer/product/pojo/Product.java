package com.lucifer.product.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description: 商品实体类
 */
@Data
@TableName(value = "product_info")
public class Product {

    /**
     * 商品id
     */
    @TableField(value = "product_id")
    private int productId;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;


    /**
     * 单价
     */
    @TableField(value = "product_price")
    private BigDecimal productPrice;

    /**
     * 库存
     */
    @TableField(value = "product_stock")
    private Integer productStock;

    /**
     * 商品描述
     */
    @TableField(value = "product_description")
    private String productDescription;


    /**
     * 小图
     */
    @TableField(value = "product_icon")
    private String productIcon;


    /**
     * 商品状态,0正常1下架
     */
    @TableField(value = "product_status")
    private Integer productStatus;


    /**
     * 类目编号
     */
    @TableField(value = "category_type")
    private Integer categoryType;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Timestamp createTime;


    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Timestamp updateTime;


}
