package com.example.demo.repositories;


import com.example.demo.models.MotorhomeDTO;
import com.example.demo.models.ProductDTO;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    private Connection conn; //database?
    private static final String CREATE_PRODUCT_SQL = "INSERT INTO product" + "(product_id, product_name, product_price) VALUES" + "(?,?,?);";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM product WHERE product_id =?";
    private static final String EDIT_PRODUCT_SQL = "UPDATE product SET product_name =?, product_price =? WHERE product_id=?;";




    public ProductRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    @Override
    public void create(ProductDTO product){
        try {
            PreparedStatement prep = conn.prepareStatement(CREATE_PRODUCT_SQL);
            {
                prep.setInt(1, product.getProductId());
                prep.setString(2, product.getProductName());
                prep.setInt(3, product.getProductPrice());
                prep.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<ProductDTO> readAll() {
        List<ProductDTO> allProducts = new ArrayList<ProductDTO>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO tempProduct = new ProductDTO();
                tempProduct.setProductId(rs.getInt("product_id"));
                tempProduct.setProductName(rs.getString(2));
                tempProduct.setProductPrice(rs.getInt(3));
                allProducts.add(tempProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProducts;
    }


    @Override
    public ProductDTO read(int productId) {
        ProductDTO productToReturn = new ProductDTO();
        try {
            PreparedStatement getSingleCustomer = conn.prepareStatement("SELECT * FROM product WHERE product_id=?");
            getSingleCustomer.setInt(1, productId);
            ResultSet rs = getSingleCustomer.executeQuery();
            while (rs.next()) {
                productToReturn = new ProductDTO();
                productToReturn.setProductId(rs.getInt("product_id"));
                productToReturn.setProductName(rs.getString(2));
                productToReturn.setProductPrice(rs.getInt(3));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return productToReturn;
    }


    @Override
    public void delete(int productId){
        try {
            PreparedStatement prep = conn.prepareStatement(DELETE_PRODUCT_SQL);
            prep.setInt(1, productId);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void edit(ProductDTO product){
        try {
            ;
            PreparedStatement prep = conn.prepareStatement(EDIT_PRODUCT_SQL);

            prep.setString(1, product.getProductName());
            prep.setInt(2, product.getProductPrice());
            prep.setInt(3, product.getProductId());

            prep.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
