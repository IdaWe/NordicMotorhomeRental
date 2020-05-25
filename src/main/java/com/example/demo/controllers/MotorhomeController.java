package com.example.demo.controllers;

import com.example.demo.models.CustomerDTO;
import com.example.demo.models.MotorhomeDTO;
import com.example.demo.repositories.CustomerRepositoryImpl;
import com.example.demo.repositories.ICustomerRepository;
import com.example.demo.repositories.IMotorhomeRepository;
import com.example.demo.repositories.MotorhomeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MotorhomeController {


    private IMotorhomeRepository motorhomeRepository;

    @Autowired
    public MotorhomeController() {
        motorhomeRepository = new MotorhomeRepositoryImpl();
    }

    /*------------------------------ Motorhome Administration ----------------------------------------------*/

    @GetMapping("/motorhomeAdministration")
    public String motorhomeAdministration(){
        return "motorhome/motorhomeAdministration";
    }

    /*------------------------------------- Create Motorhome ----------------------------------------------*/
    @GetMapping("/createMotorhome")
    public String createCustomer(Model model){
        model.addAttribute("motorhome", new MotorhomeDTO());
        return "motorhome/createMotorhome";
    }

    @PostMapping("/createMotorhome")
    public String saveMotorhome(@ModelAttribute MotorhomeDTO motorhomeDTO){
        motorhomeRepository.create(motorhomeDTO);
        return "redirect:/motorhomeAdministration";
    }

    /*------------------------------------- See all Motorhomes ----------------------------------------------*/

    @GetMapping("/allMotorhomes")
    public String allCustomers(Model model){
        model.addAttribute("motorhomes", motorhomeRepository.readAll());
        return "motorhome/allMotorhomes";
    }


    /*------------------------------------------ Find Motorhome ----------------------------------------------*/

    @GetMapping("/findMotorhome")
    public String findMotorhome(Model model){
        // if(model.getAttribute("customer") == null) {
        model.addAttribute("motorhome", new MotorhomeDTO());// laver et tomt customer object, det der står i form {customer}
        //  }
        return "motorhome/findMotorhome";
    }


    @PostMapping("/getMotorhomeById")
    public String getMotorhomeById(@ModelAttribute MotorhomeDTO motorhome,Model model) {
        MotorhomeDTO motor = motorhomeRepository.read(motorhome.getMotorhomeId());
        model.addAttribute("motorhome", motor);
        return "motorhome/findMotorhome";
    }



    /*------------------------------------- Delete Motorhome ---------------------------------------------*/


    @GetMapping("/deleteMotorhome")
    public String deleteMotorhome(Model model, @RequestParam int motorhomeId){
        MotorhomeDTO motor = motorhomeRepository.read(motorhomeId);
        model.addAttribute("motorhome", motor);
        return "motorhome/deleteMotorhome";
    }



    @PostMapping("/deleteMotorhome")
    public String deleteForGood(@RequestParam int motorhomeId){
        motorhomeRepository.delete(motorhomeId);
        return "redirect:/motorhomeAdministration";
    }


    /*---------------------------------------- Edit Customer ----------------------------------------------*/




    @GetMapping("/editMotorhome")
    public String editMotorhome(Model model, @RequestParam int motorhomeId){
        MotorhomeDTO motorhome = motorhomeRepository.read(motorhomeId);
        model.addAttribute("motorhome", motorhome);
        return "motorhome/editMotorhome";
    }



    @PostMapping("/editMotorhome")
    public String updateMotorhome(@ModelAttribute MotorhomeDTO motorhome){
        motorhomeRepository.edit(motorhome);
        return "redirect:/motorhomeAdministration";
    }


}
