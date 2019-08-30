package com.lucifer.demo.filter;

import com.alibaba.fastjson.JSON;
import com.lucifer.demo.util.StringJsonUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: lucifer
 * @date: 2019/8/21
 * @description:
 */
public class ParameterRequestWrapper extends HttpServletRequestWrapper {

    private Map<String , String[]> params = new HashMap<>();

    public ParameterRequestWrapper(HttpServletRequest request) {
        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
        super(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        Map<String, String[]> requestMap=request.getParameterMap();
        System.out.println("转化前参数："+JSON.toJSONString(requestMap));
        this.params.putAll(requestMap);
        this.modifyParameterValues();
        System.out.println("转化后参数："+JSON.toJSONString(params));
    }
    /**
     * 重写getInputStream方法  post类型的请求参数必须通过流才能获取到值
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        //非json类型，直接返回
        if(!super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)){
            return super.getInputStream();
        }
        //为空，直接返回
        String json = IOUtils.toString(super.getInputStream(), "utf-8");
        if (StringUtils.isEmpty(json)) {
            return super.getInputStream();
        }
        System.out.println("转化前参数："+json);
        Map<String,Object> map= StringJsonUtils.jsonStringToMap(json);
        System.out.println("转化后参数："+JSON.toJSONString(map));
        ByteArrayInputStream bis = new ByteArrayInputStream(JSON.toJSONString(map).getBytes(StandardCharsets.UTF_8));
        return new MyServletInputStream(bis);
    }
    /**
     * 将parameter的值去除空格后重写回去
     */
    public void modifyParameterValues(){
        Set<String> set =params.keySet();
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String key= it.next();
            String[] values = params.get(key);
            values[0] = values[0].trim();
            params.put(key, values);
        }
    }
    /**
     * 重写getParameter 参数从当前类中的map获取
     */
    @Override
    public String getParameter(String name) {
        String[]values = params.get(name);
        if(values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }
    /**
     * 重写getParameterValues
     */
    @Override
    public String[] getParameterValues(String name) {//同上
        return params.get(name);
    }

    class MyServletInputStream extends ServletInputStream {
        private ByteArrayInputStream bis;
        public MyServletInputStream(ByteArrayInputStream bis){
            this.bis=bis;
        }
        @Override
        public boolean isFinished() {
            return true;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener listener) {

        }
        @Override
        public int read(){
            return bis.read();
        }
    }

}