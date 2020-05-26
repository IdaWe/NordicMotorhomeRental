package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;



public class LeaseDTO {

    private int leaseId;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // needed for input field on html pages (in order to serve the right format)
    private Date rentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;


    public LeaseDTO(){

    }


    public LeaseDTO(int leaseId, Date rentDate, Date returnDate) {
        this.leaseId = leaseId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "LeaseDTO{" +
                "leaseId='" + leaseId + '\'' +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
