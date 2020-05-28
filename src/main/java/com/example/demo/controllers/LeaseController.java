package com.example.demo.controllers;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.LeaseDTO;
import com.example.demo.models.MotorhomeDTO;
import com.example.demo.repositories.CustomerRepositoryImpl;
import com.example.demo.repositories.ICustomerRepository;
import com.example.demo.repositories.ILeaseRepository;
import com.example.demo.repositories.LeaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LeaseController {

    private ILeaseRepository leaseRepository;
    private ICustomerRepository customerRepository;

    @Autowired
    public LeaseController(){
        leaseRepository = new LeaseRepositoryImpl();
        customerRepository = new CustomerRepositoryImpl();
    }


    /*--------------------------------- Lease Administration ----------------------------------------------*/

    @GetMapping("/leaseAdministration")
    public String leaseAdministration(){
        return "lease/leaseAdministration";
    }

    /*------------------------------------- Create Lease ----------------------------------------------*/

    @GetMapping("/createLease")
    public String createLease(Model model, @RequestParam int cusId){
        model.addAttribute("lease", new LeaseDTO());
        model.addAttribute("cusId", cusId);
        CustomerDTO cus = customerRepository.read(cusId);
        model.addAttribute("customer", cus);
        return "lease/createLease";
    }


    @PostMapping("/createLease")
    public String saveLease(@ModelAttribute LeaseDTO leaseDTO, @RequestParam int cusId, @RequestParam int motorhomeId){
        leaseRepository.create(leaseDTO, cusId, motorhomeId);
        return "redirect:/leaseAdministration";
    }
}








/*



    @GetMapping("/createLease")
    public String createLease(Model model, @RequestParam int cusId){
        model.addAttribute("lease", new LeaseDTO());
        model.addAttribute("cusId", cusId);

        return "lease/createLease";
    }


    @PostMapping("/createLease")
    public String saveLease(@ModelAttribute LeaseDTO leaseDTO, @RequestParam int cusId, @RequestParam int motorhomeId){
        leaseRepository.create(leaseDTO, cusId, motorhomeId);
        return "redirect:/leaseAdministration";
    }*/