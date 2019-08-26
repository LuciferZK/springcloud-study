package com.lucifer.morningserviceorder.pojo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description:
 */
@Data
@Entity
@Table(name = "order_master")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@TableField(value = "order_id")
    @Column(name ="order_id" )
    private String orderId;

   // @TableField(value = "buyer_name")
   @Column(name ="buyer_name" )
    private String buyerName;

   // @TableField(value = "buyer_phone")
   @Column(name ="buyer_phone" )
    private String buyerPhone;

   // @TableField(value = "buyer_address")
   @Column(name ="buyer_address" )
    private String buyerAddress;

   // @TableField(value = "buyer_openid")
   @Column(name ="buyer_openid" )
    private String buyerOpenid;

   // @TableField(value = "order_amount")
   @Column(name ="order_amount" )
    private String orderAmount;

   // @TableField(value = "order_status")
   @Column(name ="order_status" )
    private String orderStatus;

   // @TableField(value = "pay_status")
   @Column(name ="pay_status" )
    private String payStatus;

    //@TableField(value = "create_time")
    @Column(name ="create_time" )
    private Timestamp createTime;

   // @TableField(value = "update_time")
   @Column(name ="update_time" )
    private Timestamp updateTime;

}
