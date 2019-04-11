package com.nb.jingubang.utils;

import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * Created by 52613 on 2019/4/3.
 */
public class Pageable implements org.springframework.data.domain.Pageable,Serializable{

    private static final long serialVersionUID = 1L;

    /**第几页**/
    private int pageNumber;
    /**每页多少条**/
    private int pageSize;

    public Pageable() {
        super();
    }

    public Pageable(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int getOffset() {
        return this.getPageNumber()*this.getPageSize();
    }

    /**---------------------------------------------------------------------------------------------**/
    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public org.springframework.data.domain.Pageable next() {
        return null;
    }

    @Override
    public org.springframework.data.domain.Pageable previousOrFirst() {
        return null;
    }

    @Override
    public org.springframework.data.domain.Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public String toString() {
        return "Pageable{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
