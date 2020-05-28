package com.example.demo.repositories;

import com.example.demo.models.MotorhomeDTO;
import com.example.demo.models.ProductDTO;

import java.util.List;

public interface IProductRepository {


    // CRUD operations

    public void create(ProductDTO productDTO);

    public List<ProductDTO> readAll();

    public ProductDTO read(int productId);


    public void edit(ProductDTO product);

    public void delete(int productId);


}
