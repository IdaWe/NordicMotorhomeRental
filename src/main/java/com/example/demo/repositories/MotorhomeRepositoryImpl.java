package com.example.demo.repositories;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.MotorhomeDTO;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRepositoryImpl implements IMotorhomeRepository {

    private Connection conn; //database?
    private static final String CREATE_MOTORHOME_SQL = "INSERT INTO motorhome" + "(motorhome_id, motorhome_brand, motorhome_model, motorhome_type, motorhome_description, motorhome_price) VALUES" + "(?,?,?,?,?,?);";
    private static final String DELETE_MOTORHOME_SQL = "DELETE FROM motorhome WHERE motorhome_id =?";
    private static final String EDIT_MOTORHOME_SQL = "UPDATE motorhome SET motorhome_brand =?, motorhome_model =?, motorhome_type =?, motorhome_description =?, motorhome_price =? WHERE motorhome_id=?;";

    public MotorhomeRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    @Override
    public void create(MotorhomeDTO motorhome){
        try {
            PreparedStatement prep = conn.prepareStatement(CREATE_MOTORHOME_SQL);
            {
                prep.setInt(1, motorhome.getMotorhomeId());
                prep.setString(2, motorhome.getBrand());
                prep.setString(3, motorhome.getModel());
                prep.setString(4, motorhome.getType());
                prep.setString(5, motorhome.getDescription());
                prep.setInt(6, motorhome.getPrice());
                prep.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<MotorhomeDTO> readAll() {
        List<MotorhomeDTO> allMotorhomes = new ArrayList<MotorhomeDTO>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM motorhome");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MotorhomeDTO tempMotorhome = new MotorhomeDTO();
                tempMotorhome.setMotorhomeId(rs.getInt("motorhome_id"));
                tempMotorhome.setBrand(rs.getString(2));
                tempMotorhome.setModel(rs.getString(3));
                tempMotorhome.setType(rs.getString(4));
                tempMotorhome.setDescription(rs.getString(5));
                tempMotorhome.setPrice(rs.getInt(6));
                allMotorhomes.add(tempMotorhome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMotorhomes;
    }



    public MotorhomeDTO read(int motorhomeId) {
        MotorhomeDTO motorhomeToReturn = new MotorhomeDTO();
        try {
            PreparedStatement getSingleCustomer = conn.prepareStatement("SELECT * FROM motorhome WHERE motorhome_id=?");
            getSingleCustomer.setInt(1, motorhomeId);
            ResultSet rs = getSingleCustomer.executeQuery();
            while (rs.next()) {
                motorhomeToReturn = new MotorhomeDTO();
                motorhomeToReturn.setMotorhomeId(rs.getInt("motorhome_id"));
                motorhomeToReturn.setBrand(rs.getString(2));
                motorhomeToReturn.setModel(rs.getString(3));
                motorhomeToReturn.setType(rs.getString(4));
                motorhomeToReturn.setDescription(rs.getString(5));
                motorhomeToReturn.setPrice(rs.getInt(6));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return motorhomeToReturn;
    }





    public void edit(MotorhomeDTO motorhome){
        try {
            ;
            PreparedStatement prep = conn.prepareStatement(EDIT_MOTORHOME_SQL);

            prep.setString(1, motorhome.getBrand());
            prep.setString(2, motorhome.getModel());
            prep.setString(3, motorhome.getType());
            prep.setString(4, motorhome.getDescription());
            prep.setInt(5, motorhome.getPrice());
            prep.setInt(6, motorhome.getMotorhomeId());

            prep.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    @Override
    public void delete(int motorhomeId){
        try {
            PreparedStatement prep = conn.prepareStatement(DELETE_MOTORHOME_SQL);
            prep.setInt(1, motorhomeId);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}
