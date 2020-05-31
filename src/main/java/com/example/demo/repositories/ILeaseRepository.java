package com.example.demo.repositories;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.LeaseDTO;
import com.example.demo.models.MotorhomeDTO;

public interface ILeaseRepository {

    // CRUD operations

    public int create(LeaseDTO leaseDTO, int cusId, int motorhomeId);

}
