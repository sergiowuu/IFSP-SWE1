package br.edu.ifsp.cubatao.model;

import java.time.LocalDate;

public class Order {

    private int ordNo;          
    private double purchAmt;      
    private LocalDate ordDate;  
    private int customerId;      
    private int salesmanId;     
    
    public Order() {
    }
    
    public Order(int ordNo, double purchAmt, LocalDate ordDate, int customerId, int salesmanId) {
        this.ordNo = ordNo;
        this.purchAmt = purchAmt;
        this.ordDate = ordDate;
        this.customerId = customerId;
        this.salesmanId = salesmanId;
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public double getPurchAmt() {
        return purchAmt;
    }

    public void setPurchAmt(double purchAmt) {
        this.purchAmt = purchAmt;
    }

    public LocalDate getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(LocalDate ordDate) {
        this.ordDate = ordDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordNo=" + ordNo +
                ", purchAmt=" + purchAmt +
                ", ordDate=" + ordDate +
                ", customerId=" + customerId +
                ", salesmanId=" + salesmanId +
                '}';
    }
}