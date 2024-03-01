package com.softroad.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Map;

public class GlobalCache {

    // 创建一个无界缓存，即不对缓存大小做限制
    private static final Cache<Object, Object> GLOBAL_CACHE = CacheBuilder.newBuilder()
            .maximumSize(Integer.MAX_VALUE) // 设置一个很大的最大容量，表示不限制大小
            .build();

    // 获取全局缓存实例
    public static Cache<Object, Object> getCache() {
        return GLOBAL_CACHE;
    }

    // 向缓存中添加数据
    public static void put(Object key, Object value) {
        GLOBAL_CACHE.put(key, value);
    }

    public static void putAll(Map<Object,Object> map) {
        GLOBAL_CACHE.putAll(map);
    }

    // 从缓存中获取数据
    public static Object getIfPresent(Object key) {
        return GLOBAL_CACHE.getIfPresent(key);
    }

    // 从缓存中移除数据
    public static void invalidate(Object key) {
        GLOBAL_CACHE.invalidate(key);
    }

    // 清空所有缓存数据
    public static void invalidateAll() {
        GLOBAL_CACHE.invalidateAll();
    }

    // 获取缓存的大小
    public static long size() {
        return GLOBAL_CACHE.size();
    }

    // 禁止实例化
    private GlobalCache() {}
}
