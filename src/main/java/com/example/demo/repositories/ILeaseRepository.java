package com.example.demo.repositories;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.LeaseDTO;
import com.example.demo.models.MotorhomeDTO;

import java.util.List;

public interface ILeaseRepository {

    // CRUD operations

    public int create(LeaseDTO leaseDTO, int cusId, int motorhomeId);

    //public LeaseDTO read(int leaseId);

    public List<LeaseDTO> findLeasesByCustomerId(int cusId);


}
