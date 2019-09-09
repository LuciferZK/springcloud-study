package com.lucifer.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description:
 */
@Data
@TableName(value = "order_master")
public class OrderDemo  {

    @TableField(value = "order_id")
    private String orderId;

    @TableField(value = "buyer_name")
    private String buyerName;

    @TableField(value = "buyer_phone")
    private String buyerPhone;

    @TableField(value = "buyer_address")
    private String buyerAddress;

    @TableField(value = "order_amount")
    private BigDecimal orderAmount;

    @TableField(value = "order_status")
    private String orderStatus;

    @TableField(value = "pay_status")
    private String payStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}

