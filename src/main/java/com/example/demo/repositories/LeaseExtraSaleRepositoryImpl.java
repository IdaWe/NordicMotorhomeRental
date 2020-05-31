package com.example.demo.repositories;

import com.example.demo.models.LeaseDTO;
import com.example.demo.models.ProductDTO;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LeaseExtraSaleRepositoryImpl {
    private Connection conn; //database?


    private static final String CREATE_LEASE_EXTRA_SALE_SQL = "INSERT INTO lease_extra_sale" + "(lease_id, product_id, product_amount) VALUES" + "(?,?,?);";


    public LeaseExtraSaleRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    public void createLeaseExtraSale(int leaseId, int productId, int productAmount){
        try {
            PreparedStatement prep = conn.prepareStatement(CREATE_LEASE_EXTRA_SALE_SQL);
            {
                prep.setInt(1, leaseId);
                prep.setInt(2, productId);
                prep.setInt(3, productAmount);
                prep.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
