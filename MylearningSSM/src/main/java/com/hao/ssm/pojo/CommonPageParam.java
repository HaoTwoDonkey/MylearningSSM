package com.hao.ssm.pojo;

import java.io.Serializable;

/**
 * @author : Miss Wang
 * @description : 父类的通用的分页参数
 * @date : 2018/3/15 22:36
 * @copyright : ? 2018
 */
public class CommonPageParam implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer page;
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
