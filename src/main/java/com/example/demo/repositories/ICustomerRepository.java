package com.example.demo.repositories;
import com.example.demo.models.CustomerDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface ICustomerRepository {

     // CRUD operations
        public void create(CustomerDTO customerDTO);

        public CustomerDTO read(int cusId);

        public List<CustomerDTO> readAll();

        public void edit(CustomerDTO customer);

        public void delete(int cusId);
    }
