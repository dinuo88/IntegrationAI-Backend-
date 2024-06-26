package com.dinuo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dinuo
 * @Date: 2024/06/19/19:58
 */
public class UserContext {
    private static final ThreadLocal<Map<String, Long>> THREAD_LOCAL =
            new ThreadLocal<>();

    //判断线程map是否为空，为空就添加一个map
    public static Map<String, Long> getLocalMap() {
        Map<String, Long> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(10);
            THREAD_LOCAL.set(map);
        }
        return map;
    }
    //把用户信息添加到线程map中
    public static void set(String key, Long userId) {
        Map<String, Long> map = getLocalMap();
        map.put(key, userId);
    }
    //获得线程map中的数据
    public static Long get(String key) {
        Map<String, Long> map = getLocalMap();
        return map.get(key);
    }
}
