package com.dev.data.model;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 分页&排序参数
 *
 * @author Siu
 * @author drj
 * @date 2020/7/10 11:33
 * @version 0.0.1
 */
public abstract class Pagination {


    /**
     * 前端传的页码，规定前端页码从1开始，set的时候转成后端的值
     * <p>
     * 后端默认从0开始
     */
    private long page = 0;

    /**
     * 每页记录数
     */
    private long limit = 10;

    /**
     * 排序参数
     * <p>
     * 格式 [+field1,-field2,field3]
     * + 正序
     * - 降序
     * 默认正序
     */
    private List<String> sort;


    /**
     * 获取转换后的order
     *
     * @return
     */
    public String getOrder() {
        if (CollectionUtils.isEmpty(sort)) {
            return null;
        }

        return sort.stream()
                .filter(SqlOrderConvert.ORDER_FILTER)
                .distinct()
                .map(SqlOrderConvert::getOrder)
                .collect(Collectors.joining(SqlOrderConvert.DELIMITER));
    }


    // region getter/setter


    public long getPage() {
        return page;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public List<String> getSort() {
        return sort;
    }

    public void setSort(List<String> sort) {
        this.sort = sort;
    }

    /**
     * set 时转成后端的页码
     *
     * @param page
     */
    public void setPage(long page) {
        if (page > 0) {
            this.page = page - 1;
        }
    }

    /**
     * 获取前端页码
     *
     * @return
     */
    public long getViewPage() {
        return page + 1;
    }

    // endregion

    /**
     * 提供offset 获取方法
     * @return long 偏移量
     * */
    public long getOffset() {
        long offset = limit * page;
        return Math.max(offset, 0);
    }


}
