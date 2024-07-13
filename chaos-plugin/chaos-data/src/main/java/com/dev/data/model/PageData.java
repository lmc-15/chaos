/*
 * @(#) PageUtils.java 2018/09/19
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.data.model;

import java.io.Serializable;
import java.util.List;


/**
 * 分页结果
 *
 * @author dengrijin
 * @author Siu
 * @version v0.1 2020/07/17
 * @since JDK1.8
 */
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 总数
     */
    private Long total;

    /**
     * 后端页码
     */
    private Long page;

    /**
     * 每页记录数
     */
    private Long limit;
    /**
     * 列表数据
     */
    private List<T> items;

    public PageData() {
    }

    public PageData(Long total, Long page, Long limit, List<T> items) {
        this.total = total;
        this.page = page;
        this.limit = limit;
        this.items = items;
    }

    public PageData(Pagination pagination, Long total, List<T> items) {
        this.total = total;
        this.page = pagination.getViewPage();
        this.limit = pagination.getLimit();
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }
}
