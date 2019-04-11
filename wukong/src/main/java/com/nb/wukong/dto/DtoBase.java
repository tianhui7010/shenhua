package com.nb.wukong.dto;

import com.nb.jingubang.utils.Pageable;

import java.io.Serializable;

/**
 * Created by 52613 on 2019/4/10.
 */
public class DtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    private int pageNumber;
    private int pageSize;
    private Pageable pageable;

    public DtoBase() {
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Pageable getPageable() {
        return new Pageable(this.pageNumber, this.pageSize);
    }
}
