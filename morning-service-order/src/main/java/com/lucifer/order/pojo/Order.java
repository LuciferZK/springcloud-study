package com.lucifer.order.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description:
 */
@Data
@TableName(value = "order_master")
public class Order {

    @TableField(value = "order_id")
    private String orderId;

    @TableField(value = "buyer_name")
    private String buyerName;

    @TableField(value = "buyer_phone")
    private String buyerPhone;

    @TableField(value = "buyer_address")
    private String buyerAddress;

    @TableField(value = "buyer_openid")
    private String buyerOpenid;

    @TableField(value = "order_amount")
    private String orderAmount;

    @TableField(value = "order_status")
    private String orderStatus;

    @TableField(value = "pay_status")
    private String payStatus;

    @TableField(value = "create_time")
    private Timestamp createTime;

    @TableField(value = "update_time")
    private Timestamp updateTime;

}
