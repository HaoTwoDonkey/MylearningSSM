package com.hao.ssm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/15 12:58
 */
public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long total;

    private List<T> rows;

    public PageBean(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
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
}
