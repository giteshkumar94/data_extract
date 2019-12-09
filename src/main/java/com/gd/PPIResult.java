package com.gd;

import java.util.LinkedList;
import java.util.List;

public class PPIResult implements Comparable<PPIResult>{
    private Integer pageNumber;
    private List<PPI> ppis = new LinkedList<>();
    private List<RD> rdata = new LinkedList<>();

    @Override
    public int compareTo(PPIResult other) {
        return this.pageNumber.compareTo(other.getPageNumber());
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<PPI> getPpis() {
        return ppis;
    }

    public void setPpis(List<PPI> ppis) {
        this.ppis = ppis;
    }

    public List<RD> getRdata() {
        return rdata;
    }

    public void setRdata(List<RD> rdata) {
        this.rdata = rdata;
    }
}
