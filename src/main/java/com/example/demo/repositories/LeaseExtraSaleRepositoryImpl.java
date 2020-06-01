package com.example.demo.repositories;

import com.example.demo.models.LeaseDTO;
import com.example.demo.models.LeaseExtraSaleDTO;
import com.example.demo.models.ProductDTO;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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




    public List<LeaseExtraSaleDTO> findExtraSaleByLeaseId(int leaseId) {
        List<LeaseExtraSaleDTO> allExtraSale = new ArrayList<LeaseExtraSaleDTO>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM lease_extra_sale WHERE lease_id=?");
            ps.setInt(1, leaseId); //1 repræsentere bare spørgsmålstegnet ovenover ^^

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LeaseExtraSaleDTO tempExtraSale = new LeaseExtraSaleDTO();
                //tempExtraSale.setLeaseId(rs.getInt("lease_id"));
                tempExtraSale.setProductId(rs.getInt("product_id"));
                tempExtraSale.setProductAmount(rs.getInt("product_id"));
                allExtraSale.add(tempExtraSale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allExtraSale;
    }

}
