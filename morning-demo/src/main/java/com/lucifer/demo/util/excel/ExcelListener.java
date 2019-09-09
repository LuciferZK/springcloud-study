package com.lucifer.demo.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucifer.demo.pojo.OrderDemo;
import com.lucifer.demo.service.OrderService;
import com.lucifer.demo.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/28
 * @description: 解析监听器
 * 每解析一行会回调invoke()方法。
 * 整个excel解析结束会执行doAfterAllAnalysed()方法
 */
@Slf4j
public class ExcelListener extends AnalysisEventListener {

    private OrderServiceImpl orderServiceImpl;

    public ExcelListener(OrderServiceImpl orderServiceImpl) {
        super();
        this.orderServiceImpl = orderServiceImpl;
    }

    private List<Object>  data = new ArrayList<>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        System.out.println(context.getCurrentSheet());
        data.add(object);
        if(data.size()>=100){
            doSomething();
            data.clear();
            //data = new ArrayList<>();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        doSomething();
    }

    public void doSomething(){
        List<OrderDemo> list=new ArrayList<>();
        for (Object o:data) {
            String jsonString = JSONObject.toJSONString(o);
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            OrderDemo OrderDemo = JSON.toJavaObject(jsonObject, OrderDemo.class);
            list.add(OrderDemo);
        }
        orderServiceImpl.saveBatch(list);
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}