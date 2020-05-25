package com.example.demo.repositories;
import com.example.demo.models.CustomerDTO;
import com.example.demo.models.MotorhomeDTO;

import java.util.List;


public interface IMotorhomeRepository {

    // CRUD operations
    public void create(MotorhomeDTO motorhomeDTO);

    public List<MotorhomeDTO> readAll();

    public MotorhomeDTO read(int motorhomeId);


    public void edit(MotorhomeDTO motorhome);

    public void delete(int motorhomeId);


}
