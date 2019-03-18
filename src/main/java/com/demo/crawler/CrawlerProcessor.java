package com.demo.crawler;


import com.demo.cache.CacheManagerImpl;
import com.demo.cache.ICacheManager;
import com.demo.cache.News;
import com.demo.common.DateUtils;
import com.demo.config.CrawlerWeb;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

import static com.demo.config.CrawlerWeb.*;

/**
 * @author code4crafter@gmail.com <br>
 * @since 0.3.2
 */
public class CrawlerProcessor implements PageProcessor {

    private ICacheManager iCacheManager = new CacheManagerImpl();

    /**
     * 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    /**
     * process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
     * @param page page
     */
    @Override
    public void process(Page page) {

        System.out.println("url="+page.getUrl().toString());

        if(CrawlerWeb.getUrlList().contains(page.getUrl().toString())){
            /**
             * 定义如何抽取信息
             * 可以通过四种方式
             * 1  css选择器 $("h1.entry-title") 比xpath简单 写复杂抽取规则比较麻烦
             * 2  xpath 本来用于xml获取元素的一种查询语言 用于html也是比较方便
             * 3  regex 正则
             * 4  JsonPath 类似xpath 主要用于json数据 快速定位
             */
            /**
             * page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all()
             * 表示用于获取所有满足这个正则表达式的链接
             * page.addTargetRequests
             * 将这些链接加入到待抓取的队列中
             */
            List<String> list = page.getHtml().xpath("/html/body/div[4]/div/div/div[1]/div[1]/div/dl/dd/h1/a/@href").all();

            for(String item:list){
                item= CrawlerWeb.getBaseUrl()+item;
            }
            page.addTargetRequests(list);
        }else{
            /**
             * 标题
             */
            Selectable title = page.getHtml().xpath("//*[@id=\"content\"]/div/div[2]/div[1]/div[1]/h2");
            String titleString = title.toString();
            if(title.toString().contains("河北")){
                Selectable body = page.getHtml().xpath("//*[@id=\"content\"]/div/div[2]/div[1]/div[2]/div[2]");
                String bodyString = body.toString();
                String dat = titleString.substring(4,titleString.indexOf("日")+1);
                System.out.println("标题："+titleString);
                System.out.println("内容："+bodyString);
                System.out.println("时间："+dat);
                System.out.println("转化时间；"+DateUtils.dateConverter(dat));
                News news = new News(titleString, bodyString, DateUtils.dateConverter(dat));
                System.out.println(news.toString());
                iCacheManager.putCache(news.getTimestamp(),news);

            }
        }
    }


    @Override
    public Site getSite() {
        return site;
    }

    public static void start(){

            Spider.create(new CrawlerProcessor()).
                    /**
                     * 从这个链接开始抓取
                     */
                    addUrl(startUrl1,startUrl2,startUrl3,startUrl4).
                    /**
                     * 开启2个线程抓取
                     */
                    thread(2).
                    /**
                     * 启动爬虫
                     */
                    run();

    }


}
