package com.example.demo.repositories;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.LeaseDTO;
import com.example.demo.models.MotorhomeDTO;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;


public class LeaseRepositoryImpl implements ILeaseRepository {
    private Connection conn; //database?
    private static final String CREATE_LEASE_SQL = "INSERT INTO lease" + "(lease_id, cus_Id, motorhome_Id, lease_rent_date, lease_return_date) VALUES" + "(?,?,?,?,?);";
    //private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customer WHERE cus_id =?";
    //private static final String EDIT_CUSTOMER_SQL = "UPDATE customer SET cus_first_name =?, cus_last_name =?, cus_phone =?, cus_address =?, cus_zip =?, cus_city =?, cus_drivers_license_number =?, cus_email =? WHERE cus_id=?;";


    public LeaseRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    @Override
    public void create(LeaseDTO leaseDTO, int cusId, int motorhomeId){
        try {
            PreparedStatement prep = conn.prepareStatement(CREATE_LEASE_SQL);
            {
                prep.setInt(1, leaseDTO.getLeaseId());
                prep.setInt(2, cusId);
                prep.setInt(3, motorhomeId);
                prep.setDate(4, new java.sql.Date(leaseDTO.getRentDate().getTime()));
                prep.setDate(5, new java.sql.Date(leaseDTO.getReturnDate().getTime()));
                prep.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
