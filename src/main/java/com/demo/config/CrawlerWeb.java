package com.demo.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 抓爬网址管理
 * @Author: Po Lam
 * @Date: 2019/3/14 13:43
 */
public class CrawlerWeb {

    /**
     * 抓爬网站根网址
     */
    private static String baseUrl = "https://www.qinbing.cn";
    /**
     * 默认抓爬前4页
     */
    public static String startUrl1 = "https://www.qinbing.cn/Portal/Index/news/page/1/type/357";
    public static String startUrl2 = "https://www.qinbing.cn/Portal/Index/news/page/2/type/357";
    public static String startUrl3 = "https://www.qinbing.cn/Portal/Index/news/page/3/type/357";
    public static String startUrl4 = "https://www.qinbing.cn/Portal/Index/news/page/4/type/357";


    private static List<String> urlList = new ArrayList<>();

    public static List<String> getUrlList() {
        urlList.add(startUrl1);
        urlList.add(startUrl2);
        urlList.add(startUrl3);
        urlList.add(startUrl4);
        return urlList;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}
