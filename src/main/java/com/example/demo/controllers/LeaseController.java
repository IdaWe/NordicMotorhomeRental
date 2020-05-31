package com.example.demo.controllers;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.LeaseDTO;
import com.example.demo.models.MotorhomeDTO;
import com.example.demo.models.ProductDTO;
import com.example.demo.repositories.*;
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
    private LeaseExtraSaleRepositoryImpl leaseExtraSaleRepository;
    private IProductRepository productRepository;

    @Autowired
    public LeaseController(){
        leaseRepository = new LeaseRepositoryImpl();
        customerRepository = new CustomerRepositoryImpl();
        leaseExtraSaleRepository = new LeaseExtraSaleRepositoryImpl();
        productRepository = new ProductRepositoryImpl();
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
    public String saveLease(@ModelAttribute LeaseDTO leaseDTO, @RequestParam int cusId, @RequestParam int motorhomeId, @RequestParam int towels, @RequestParam int bedLinen){
        int leaseId = leaseRepository.create(leaseDTO, cusId, motorhomeId); //denne skal returnere det oprettede leaseid til metoden nedenunder

        ProductDTO towelProduct = productRepository.find("Towels");
        leaseExtraSaleRepository.createLeaseExtraSale(leaseId, towelProduct.getProductId(), towels); //her bruges leaseId som returneres fra metoden ovenover

        ProductDTO bedLinenProduct = productRepository.find("Bed linen"); //Bed linen navnet skal være det samme som det i den oprettede product tabel
        leaseExtraSaleRepository.createLeaseExtraSale(leaseId, bedLinenProduct.getProductId(), bedLinen); //her bruges leaseId som returneres fra metoden ovenover


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