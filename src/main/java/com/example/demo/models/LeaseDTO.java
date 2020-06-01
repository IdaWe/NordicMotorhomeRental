package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;



public class LeaseDTO {

    private int leaseId;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // needed for input field on html pages (in order to serve the right format)
    private Date rentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    //disse to variable(foreign keys) bruges til metoden findLeasesByCustomerId
    //det ovenover er som sådan lige meget -> det vigtige er at ens DTO reflektere databasen under normale omstændigheder
    private int motorhomeId;
    private int cusId;


    public LeaseDTO(){

    }


    public LeaseDTO(int leaseId, Date rentDate, Date returnDate, int motorhomeId, int cusId) {
        this.leaseId = leaseId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.motorhomeId = motorhomeId;
        this.cusId = cusId;
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

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }


    @Override
    public String toString() {
        return "LeaseDTO{" +
                "leaseId=" + leaseId +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", motorhomeId=" + motorhomeId +
                ", cusId=" + cusId +
                '}';
    }
}
