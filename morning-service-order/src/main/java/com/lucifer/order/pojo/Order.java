package com.lucifer.order.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucifer.order.util.excel.BaseReadModel;
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
public class Order extends BaseReadModel {

    @ExcelProperty(index = 0, value = "订单编号")
    @TableField(value = "order_id")
    private String orderId;

    @ExcelProperty(index = 1, value = "买家姓名")
    @TableField(value = "buyer_name")
    private String buyerName;

    @ExcelProperty(index = 2, value = "买家手机号")
    @TableField(value = "buyer_phone")
    private String buyerPhone;

    @ExcelProperty(index = 3, value = "买家地址")
    @TableField(value = "buyer_address")
    private String buyerAddress;

    @TableField(value = "buyer_openid")
    private String buyerOpenid;

    @ExcelProperty(index = 4, value = "订单总金额")
    @TableField(value = "order_amount")
    private BigDecimal orderAmount;

    @ExcelProperty(index = 5, value = "订单状态")
    @TableField(value = "order_status")
    private String orderStatus;

    @ExcelProperty(index = 6, value = "支付状态")
    @TableField(value = "pay_status")
    private String payStatus;

    @ExcelProperty(index = 7, value = "创建时间",format = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ExcelProperty(index = 8, value = "修改时间",format = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
