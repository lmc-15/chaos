package com.dev.core.util;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/8 21:55
 */
public class CollUtil {
    private CollUtil(){}
    /**
     * 集合是否为非空
     *
     * @param collection 集合
     * @return 是否为非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 集合是否为空
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
    /**
     * Is empty boolean.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the boolean
     */
    public static <T> boolean isEmpty(T[] list) {
        return (list == null || list.length == 0);
    }

    /**
     * Is not empty boolean.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the boolean
     */
    public static <T> boolean isNotEmpty(T[] list) {
        return !isEmpty(list);
    }



    /**
     * Is empty boolean.
     *
     * @param ch the ch
     * @return the boolean
     */
    public static boolean isEmpty(CharSequence ch) {
        return (ch == null || ch.length() == 0);
    }

    /**
     * Is not empty boolean.
     *
     * @param ch the ch
     * @return the boolean
     */
    public static boolean isNotEmpty(CharSequence ch) {
        return !isEmpty(ch);
    }

    /**
     * Is empty boolean.
     *
     * @param map the map
     * @return the boolean
     */
    public static boolean isEmpty(Map map) {
        return (map == null || map.isEmpty());
    }

    /**
     * Is not empty boolean.
     *
     * @param map the map
     * @return the boolean
     */
    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    /**
     * Is empty boolean.
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isEmpty(Object object) {
        return (object == null);
    }

    /**
     * Is not empty boolean.
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }


    /**
     * Gets or default.
     *
     * @param <T> the type parameter
     * @param t   the t
     * @param val the  default val
     * @return the t or default
     */
    public static <T> T getOrDefault(T t, T val) {
        if (isEmpty(t)) {
            return val;
        }
        return t;
    }
}
