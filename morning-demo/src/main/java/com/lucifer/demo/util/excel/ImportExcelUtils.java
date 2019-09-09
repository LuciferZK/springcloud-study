package com.lucifer.demo.util.excel;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.lucifer.demo.pojo.Order;
import com.lucifer.demo.service.OrderService;
import com.lucifer.demo.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author: lucifer
 * @date: 2019/8/28
 * @description: 导入Excel工具类
 */
@Slf4j
public class ImportExcelUtils {


    /**
     * 07版本excel读数据量大于1千行，内部采用回调方法.
     *
     * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
     */
    public static void saxReadListStringV2007(HttpServletRequest request, OrderServiceImpl orderServiceImpl) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile requestFile = multipartRequest.getFile("file");
        String originalFilename = requestFile.getOriginalFilename();
        if (!originalFilename.endsWith(ExcelTypeEnum.XLS.getValue()) && !originalFilename.endsWith(ExcelTypeEnum.XLSX.getValue())) {
            log.error("Excel导入错误文件名称：{}", originalFilename);
            throw new RuntimeException("不是Excel格式文件");
        }
        InputStream inputStream = null;
        try {
            inputStream = requestFile.getInputStream();
            if (inputStream == null) {
                return;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            AnalysisEventListener excelListener = new ExcelListener(orderServiceImpl);
            EasyExcelFactory.readBySax(bufferedInputStream, new Sheet(1, 1, Order.class), excelListener);
        } finally {
            inputStream.close();
        }
    }


}
