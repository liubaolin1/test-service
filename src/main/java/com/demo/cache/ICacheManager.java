package com.demo.cache;


import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: Po Lam
 * @Date: 2019/3/8 15:48
 */
public interface ICacheManager {

    /**
     * 存入缓存
     * @param cache
     */
    void putCache(Object key, News cache);

    /**
     * 存入缓存
     * @param cache
     */
    void putCache2(Long cache);

    /**
     * 清空缓存
     */
    void clearCache();

    /**
     * 清空缓存
     */
    void clearCache2();

    /**
     * 获取缓存集合
     * @return
     */
    Map<String, News> getCache();

    /**
     * 获取缓存集合
     * @return
     */
    List<Long> getCache2();
}
