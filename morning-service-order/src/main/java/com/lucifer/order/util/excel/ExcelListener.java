package com.lucifer.order.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/28
 * @description: 解析监听器
 * 每解析一行会回调invoke()方法。
 * 整个excel解析结束会执行doAfterAllAnalysed()方法
 */

public class ExcelListener extends AnalysisEventListener {

    /**
     * 自定义用于暂时存储data。
     * 可以通过实例获取该值
     */
    private List<Object> datas = new ArrayList<Object>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        System.out.println("当前行：" + context.getCurrentRowNum());
        System.out.println(object);
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        datas.add(object);
        //根据自己业务做处理
        doSomething(object);
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //解析结束销毁不用的资源
        datas.clear();
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}