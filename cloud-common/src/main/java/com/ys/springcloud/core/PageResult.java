package com.ys.springcloud.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果
 *
 * @author zhuyong
 * @date 2017年11月1日
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 9036385901877505532L;
    /**
     * 总记录条数
     */
    private long total;
    /**
     * 结果集合
     */
    private List<T> rows;

    /**
     * 结果集合
     */
    private Integer pages;

    /**
     * 构造分页模型
     *
     * @param total
     * @param rows
     */
    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
    /**
     * 构造分页模型
     *
     * @param total
     * @param rows
     */
    public PageResult(long total, List<T> rows,Integer pages) {
        this.total = total;
        this.rows = rows;
        this.pages = pages;
    }

    /**
     * 构造分页模型（默认无数据）
     */
    public PageResult() {
        this(0, new ArrayList<>());
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPages() {
        return pages;
    }
}
