package com.dev.data.model;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 分页对象转换
 *
 * @author dengrijin
 * @version v0.1 2020/07/17
 * @since JDK1.8
 */
public class PageConvert {
    private PageConvert() {
    }

    /**
     * 转换成 mybatis plus 分页对象
     *
     * @param pagination
     * @param <T>
     * @return
     */
    public static <T> Page<T> toMybatisPage(Pagination pagination) {
        Page<T> page = new Page<>();
        page.setSize(pagination.getLimit());
        page.setCurrent(pagination.getViewPage());
        List<String> sort = pagination.getSort();
        if (!CollectionUtils.isEmpty(sort)) {
            page.setOrders(pagination.getSort().stream()
                    .filter(SqlOrderConvert.ORDER_FILTER)
                    .distinct()
                    .map(SqlOrderConvert::getOrderItem)
                    .collect(Collectors.toList()));
        }
        return page;
    }

    /**
     * 转换成 PageData对象
     *
     * @param page
     * @param <T>
     * @return
     */
    public static <T> PageData<T> toPageData(IPage<T> page) {
        return new PageData<>(page.getTotal(), page.getCurrent(), page.getSize(), page.getRecords());
    }
}
