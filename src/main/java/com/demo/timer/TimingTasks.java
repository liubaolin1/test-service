package com.demo.timer;

import com.demo.cache.ICacheManager;
import com.demo.cache.News;
import com.demo.common.RegxUtils;
import com.demo.crawler.CrawlerProcessor;
import com.demo.mail.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: 定时任务
 * @Author: Po Lam
 * @Date: 2019/3/8 9:17
 */
@Component
public class TimingTasks {

    @Autowired
    private ICacheManager iCacheManager;

    private long sid = 0;

    /**
     * 定时监测缓存中的数据
     */
    @Scheduled(cron="0/30 * * * * ? ")
    public void Demo1(){
        sid++;
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"  定时任务执行"+sid+"次");

        List<Long> list = new ArrayList<>();
        Map<String, News> cache = iCacheManager.getCache();
        if(cache!=null && !cache.isEmpty()){
            for(String it:cache.keySet()){
                list.add(Long.parseLong(it));
            }
            Collections.sort(list);


            Long aLong = list.get(list.size() - 1);

            News news = cache.get(aLong + "");

            System.out.println(news.getTitle());

            /**
             * 在这里调用发送email接口 或是 发送微信等
             */
            Long max;
            if(iCacheManager.getCache2().isEmpty()){
                max=0L;
            }else{
                max=iCacheManager.getCache2().get(iCacheManager.getCache2().size()-1);
            }

            if(!aLong.equals(max)){

                Mail mail = new Mail(RegxUtils.getNewString(news.getTitle().trim()),news.getBody());
                boolean f = mail.send();
                if(f){
                    System.out.println("发送成功");
                    iCacheManager.clearCache2();
                    iCacheManager.putCache2(aLong);
                    /**
                     * 清除缓存
                     */
                    iCacheManager.clearCache();
                    System.out.println("缓存清除");

                    System.out.println("最后发送时间："+iCacheManager.getCache2());
                }
            }else{
                System.out.println("本条记录已经发送");
                iCacheManager.clearCache();
            }





        }



    }

    /**
     * 定时调用抓爬服务
     * 0 0/5 * * * ?
     * 0 0 0/1 * * ?
     */
    @Scheduled(cron="0 0/3 * * * ?")
    public void crawler(){
        CrawlerProcessor.start();
    }
}
