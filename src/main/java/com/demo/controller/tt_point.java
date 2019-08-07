package com.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tt_point {

    private static String url = "http://10.39.1.207:9200/news_new_keyword/detail/";

    public static void main(String[] args) {
        tt_point tt_point2 = new tt_point();
        Integer[] arr = TArray.arr;
        for(Integer a:arr){
            tt_point2.delete(url+a,a+"");
        }

    }

    /**
     * http clint 请求
     * @param url
     * @return
     */
    public String get(String url){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpGet=new HttpGet(url);
        httpGet.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpGet.setHeader("Connection", "keep-alive");

        CloseableHttpResponse execute = null;
        String resu = null;
        try {
            execute = httpClient.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            resu = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("调用完成，返回结果如下：");
        System.out.println(resu);
        return  "";
    }


    public String delete(String url,String params){
//        System.out.println(params);
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpDelete httpDelete=new HttpDelete(url);
        httpDelete.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpDelete.setHeader("Content-Type", "application/json");

        CloseableHttpResponse httpResponse = null;
        String resu = null;
        try {
            httpResponse=httpClient.execute(httpDelete);
            HttpEntity entity = httpResponse.getEntity();
            resu = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("调用完成，返回结果如下：");
//        System.out.println(resu);
        return  null;
    }
}
