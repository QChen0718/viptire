package com.example.notificationtest.entity;

import java.util.List;

public class HomeResponse {
//    "totalPage":0.0,"currentPage":1.0,"pageSize":20.0,"total":0.0,"result"
    private double totalPage;
    private double currentPage;
    private double pageSize;
    private double total;
    private List<HomeResultResponse> result;

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

    public List<HomeResultResponse> getResult() {
        return result;
    }

    public void setResult(List<HomeResultResponse> result) {
        this.result = result;
    }
}

