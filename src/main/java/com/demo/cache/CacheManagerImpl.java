package com.demo.cache;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: Po Lam
 * @Date: 2019/3/8 15:49
 */
@Service
public class CacheManagerImpl implements ICacheManager {
    /**
     * 静态存储
     */
    private static Map<String, News> caches = new ConcurrentHashMap<String, News>();
    private static List<Long> caches2 = new ArrayList<>();
    public static void main(String[] args) {
        CacheManagerImpl cacheManager = new CacheManagerImpl();
        News n1  = new News("t1","b1",111);
        News n2  = new News("t1","b1",112);
        News n3  = new News("t1","b1",113);

        cacheManager.putCache(String.valueOf(n1.getTimestamp()),n1);
        cacheManager.putCache(String.valueOf(n2.getTimestamp()),n2);
        cacheManager.putCache(String.valueOf(n3.getTimestamp()),n3);
        System.out.println("长度"+caches.size());

    }
    /**
     * 存入缓存
     * @param cache
     */
    @Override
    public void putCache(Object key, News cache) {
        caches.put(String.valueOf(key), cache);
    }


    /**
     * 存入缓存
     * @param cache
     */
    @Override
    public void putCache2(Long cache) {
        caches2.add(cache);
    }
    /**
     * 清空缓存
     */
    @Override
    public void clearCache() {
        caches.clear();
    }

    @Override
    public void clearCache2() {
        caches2.clear();
    }

    /**
     * 获取缓存集合
     *
     * @return
     */
    @Override
    public Map<String, News> getCache() {
        return caches;
    }

    /**
     * 获取缓存集合
     *
     * @return
     */
    @Override
    public List<Long> getCache2() {
        Collections.sort(caches2);
        return caches2;
    }

}
