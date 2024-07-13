package com.dev.data.model;


import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.function.Predicate;

/**
 * 排序逻辑转换
 *
 * @author dengrijin
 * @version v0.1 2020/07/10
 * @see
 * @since JDK1.8
 */
public class SqlOrderConvert {

    public static final String DESC_FLAG = "-";
    public static final String ASC_FLAG = "+";
    public static final String ASC = " ASC";
    public static final String DESC = " DESC";
    public static final String DELIMITER = ",";
    public static final Predicate<String> ORDER_FILTER =
            (s) -> StringUtils.isNotBlank(s) && !s.equals(SqlOrderConvert.ASC_FLAG) && !s.equals(SqlOrderConvert.DESC_FLAG);


    /**
     * 根据字段的格式转换成排序字段
     * 格式 [+field1,-field2,field3]
     * + 正序
     * - 降序
     * 默认正序
     *
     * @param field
     * @return
     */
    public static String getOrder(String field) {
        if (field.startsWith(DESC_FLAG)) {
            return field.substring(1) + DESC;
        }
        if (field.startsWith(ASC_FLAG)) {
            return field.substring(1) + ASC;
        }
        return field + ASC;
    }

    /**
     * 根据字段的格式转换成 mybatisplus 的排序对象
     * 格式 [+field1,-field2,field3]
     * + 正序
     * - 降序
     * 默认正序
     *
     * @param field
     * @return
     */
    public static OrderItem getOrderItem(String field) {
        if (field.startsWith(DESC_FLAG)) {
            return OrderItem.desc(field.substring(1));
        }

        if (field.startsWith(ASC_FLAG)) {
            return OrderItem.asc(field.substring(1));
        }
        return OrderItem.asc(field);
    }
}
