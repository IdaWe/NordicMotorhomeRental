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

import java.util.NoSuchElementException;


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



    /*------------------------------------- CREATE LEASE ----------------------------------------------*/

    @GetMapping("/createLease")
    public String createLease(Model model, @RequestParam int cusId){
        model.addAttribute("lease", new LeaseDTO());
        model.addAttribute("cusId", cusId);
        model.addAttribute("towels", 0);
        model.addAttribute("bedLinen", 0);
        model.addAttribute("childSeat", 0);
        model.addAttribute("gps", 0);
        model.addAttribute("bikeRack", 0);
        model.addAttribute("picnicTable", 0);
        model.addAttribute("picnicChairs", 0);



        CustomerDTO cus = customerRepository.read(cusId);
        model.addAttribute("customer", cus);
        return "lease/createLease";
    }


    @PostMapping("/createLease")
    public String saveLease(@ModelAttribute LeaseDTO leaseDTO, @RequestParam int cusId, @RequestParam int motorhomeId, @RequestParam int towels, @RequestParam int bedLinen,
                            @RequestParam int childSeat, @RequestParam int gps, @RequestParam int bikeRack, @RequestParam int picnicTable, @RequestParam int picnicChairs){
        int leaseId = leaseRepository.create(leaseDTO, cusId, motorhomeId); //denne skal returnere det oprettede leaseid til metoden nedenunder
        //metoden her under tjekker at hvis id er = -1 så thrower den en fejl
        if (leaseId == -1) {
            return "redirect:/customerLeaseManagement";
        }

        //@RequestParam int towels <-- lavet som int oppe i parameter, altså opretter den kun productet i lease extra hvis der rent faktisk tilføjes et produkt når man opretter lease
        if(towels > 0) {
            ProductDTO towelProduct = productRepository.find("Towels");
            leaseExtraSaleRepository.createLeaseExtraSale(leaseId, towelProduct.getProductId(), towels); //her bruges leaseId som returneres fra metoden ovenover-ovenover
        }
        if(bedLinen > 0) {
            ProductDTO bedLinenProduct = productRepository.find("Bed linen"); //Bed linen navnet skal være det samme som det i den oprettede product tabel
            leaseExtraSaleRepository.createLeaseExtraSale(leaseId, bedLinenProduct.getProductId(), bedLinen); //her bruges leaseId som returneres fra metoden ovenover
        }
        if(childSeat > 0) {
            ProductDTO childSeatProduct = productRepository.find("Child seat");
            leaseExtraSaleRepository.createLeaseExtraSale(leaseId, childSeatProduct.getProductId(), childSeat);
        }
        if(gps > 0) {
            ProductDTO gpsProduct = productRepository.find("GPS");
            leaseExtraSaleRepository.createLeaseExtraSale(leaseId, gpsProduct.getProductId(), gps);
        }
        if(bikeRack > 0) {
            ProductDTO bikeRackProduct = productRepository.find("Bike rack");
            leaseExtraSaleRepository.createLeaseExtraSale(leaseId, bikeRackProduct.getProductId(), bikeRack);
        }
        if(picnicTable > 0) {
            ProductDTO picnicTableProduct = productRepository.find("Picnic table");
            leaseExtraSaleRepository.createLeaseExtraSale(leaseId, picnicTableProduct.getProductId(), picnicTable);
        }
        if(picnicChairs > 0) {
            ProductDTO picnicChairsProduct = productRepository.find("Picnic chairs");
            leaseExtraSaleRepository.createLeaseExtraSale(leaseId, picnicChairsProduct.getProductId(), picnicChairs);
        }
        return "redirect:/customerLeaseManagement";
    }



    /*------------------------------------------ FIND LEASE ----------------------------------------------*/

       //DENNE CONTROLLER ER LAVET UNDER COSTUMERCONTROLLER i getCustomerById metoden






}


