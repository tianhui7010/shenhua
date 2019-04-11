package com.nb.jingubang.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 52613 on 2019/4/9.
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前第几页
     **/
    private Integer pageNumber = 0;
    /**
     * 每页显示多少条
     **/
    private Integer pageSize = 0;

    /**总数**/
    private long dataTotal;

    /**总页数**/
    private long pageTotal;

    /**查询结果**/
    private List<T> content;

    public Page() {
      super();
    }



    public Page( long dataTotal, long pageTotal,List<T> content,Integer pageNumber,Integer pageSize) {
        this.dataTotal = dataTotal;
        this.pageTotal = pageTotal;
        this.content = content;
        this.pageNumber=pageNumber;
        this.pageSize=pageSize;
    }

    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getDataTotal() {
        return this.dataTotal;
    }

    public void setDataTotal(long dataTotal) {
        this.dataTotal = dataTotal;
    }

    public long getPageTotal() {
        return this.pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getContent() {
        return this.content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Page{" +
                "content=" + content +
                ", pageTotal=" + pageTotal +
                ", dataTotal=" + dataTotal +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
