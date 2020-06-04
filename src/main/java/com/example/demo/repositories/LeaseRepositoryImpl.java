package com.example.demo.repositories;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.LeaseDTO;
import com.example.demo.models.ProductDTO;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


public class LeaseRepositoryImpl implements ILeaseRepository {
    private Connection conn; //database?
    LeaseExtraSaleRepositoryImpl leaseExtraSaleRepositoryImpl;
    ProductDTO productDTO;

    private static final String CREATE_LEASE_SQL = "INSERT INTO lease" + "(lease_id, cus_Id, motorhome_Id, lease_rent_date, lease_return_date) VALUES" + "(?,?,?,?,?);";
    //private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customer WHERE cus_id =?";
    //private static final String EDIT_CUSTOMER_SQL = "UPDATE customer SET cus_first_name =?, cus_last_name =?, cus_phone =?, cus_address =?, cus_zip =?, cus_city =?, cus_drivers_license_number =?, cus_email =? WHERE cus_id=?;";


    public LeaseRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    @Override
    public int create(LeaseDTO leaseDTO, int cusId, int motorhomeId) {
        try {
            String generatedColumns[] = {"lease_id"};                                                   //<----høre til metode A:
            PreparedStatement prep = conn.prepareStatement(CREATE_LEASE_SQL, generatedColumns);
            {
                prep.setInt(1, leaseDTO.getLeaseId());
                prep.setInt(2, cusId);
                prep.setInt(3, motorhomeId);
                prep.setDate(4, new java.sql.Date(leaseDTO.getRentDate().getTime()));
                prep.setDate(5, new java.sql.Date(leaseDTO.getReturnDate().getTime()));
                prep.executeUpdate();


                                                                         //Metode A: returnere hele den indsatte row(som er leasen)
                java.sql.ResultSet rs = prep.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);                  //Her henter vi leaseId ud fra den returnerede række
                    System.out.println("Inserted ID -" + id);                // display inserted record
                    return id;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;                                                     //returnere den -1 betyder det at der er en fejl
    }







    @Override
    public List<LeaseDTO> findLeasesByCustomerId(int cusId) {
        List<LeaseDTO> allLeases = new ArrayList<LeaseDTO>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM lease WHERE cus_id=?");
            ps.setInt(1, cusId); //1 repræsentere bare spørgsmålstegnet ovenover ^^

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LeaseDTO tempLease = new LeaseDTO();
                tempLease.setLeaseId(rs.getInt("lease_id")); //lease
                tempLease.setCusId(rs.getInt("cus_id"));
                tempLease.setMotorhomeId(rs.getInt("motorhome_id"));
                tempLease.setRentDate(rs.getDate("lease_rent_date"));
                tempLease.setReturnDate(rs.getDate("lease_return_date"));
                allLeases.add(tempLease);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allLeases;
    }

}