package com.lucifer.order.util.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.lucifer.order.constant.BaseConstant;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author: lucifer
 * @date: 2019/8/28
 * @description: Excel导出工具类
 */
public class ExportExcelUtils {

    public static void writeV2007(List<? extends BaseRowModel> data, Class<? extends BaseRowModel> clazz) throws IOException {
        String filePath = BaseConstant.EXCEL_STORAGE_PATH + System.currentTimeMillis() + ExcelTypeEnum.XLSX.getValue();
        //判断文件是否存在
        if (StringUtils.isNotBlank(filePath)) {
            new File(BaseConstant.EXCEL_STORAGE_PATH).mkdirs();
        }
        OutputStream out = new FileOutputStream(filePath);
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0, clazz);
            writer.write(data, sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
