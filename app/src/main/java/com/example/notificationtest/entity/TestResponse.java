package com.example.notificationtest.entity;

import java.io.Serializable;

public class TestResponse implements Serializable {

    /**
     * totalPage : 0.0
     * currentPage : 1.0
     * pageSize : 20.0
     * total : 0.0
     */

    private double totalPage;
    private double currentPage;
    private double pageSize;
    private double total;

    public double getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(double totalPage) {
        this.totalPage = totalPage;
    }

    public double getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(double currentPage) {
        this.currentPage = currentPage;
    }

    public double getPageSize() {
        return pageSize;
    }

    public void setPageSize(double pageSize) {
        this.pageSize = pageSize;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
