package com.example.demo.controllers;

import com.example.demo.models.CustomerDTO;
import com.example.demo.repositories.ICustomerRepository;
import com.example.demo.repositories.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CustomerController {


    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerController(){
        customerRepository = new CustomerRepositoryImpl();
    }



 /*------------------------------ Customer Administration ----------------------------------------------*/

    @GetMapping("/customerAdministration")
    public String customerAdministration(/*Model model*/){
        /*model.addAttribute("students", studentRepository.readAll());*/
        return "customer/customerAdministration";
    }

    /*------------------------------------- Create Customer ----------------------------------------------*/
    @GetMapping("/createCustomer")
    public String createCustomer(Model model){
        model.addAttribute("customer", new CustomerDTO());
        return "customer/createCustomer";
    }

    @PostMapping("/createCustomer")
    public String saveCustomer(@ModelAttribute CustomerDTO customerDTO){
        customerRepository.create(customerDTO);
        return "redirect:/customerAdministration";
    }

    /*------------------------------------- See all Customers ----------------------------------------------*/

    @GetMapping("/allCustomers")
    public String allCustomers(Model model){
        model.addAttribute("customers", customerRepository.readAll());
        return "customer/allCustomers";
    }


    /*------------------------------------------ Find Customer ----------------------------------------------*/

    @GetMapping("/findCustomer")
    public String findCustomer(Model model){
       // if(model.getAttribute("customer") == null) {
            model.addAttribute("customer", new CustomerDTO());// laver et tomt customer object -> det der står i form {customer}
      //  }
        return "customer/findCustomer";
    }


    @PostMapping("/getCustomerById")
    public String getCustomerById(@ModelAttribute CustomerDTO customer,Model model) {
        CustomerDTO cus = customerRepository.read(customer.getCusId());
        model.addAttribute("customer", cus);
        return "customer/findCustomer";
    }


    /*------------------------------------- Delete Customer ---------------------------------------------*/

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(Model model, @RequestParam int cusId){
        CustomerDTO cus = customerRepository.read(cusId);
        model.addAttribute("customer", cus);
        return "customer/deleteCustomer";
    }



    @PostMapping("/deleteCustomer")
    public String deleteForGood(@RequestParam int cusId){
        customerRepository.delete(cusId);
        return "redirect:/customerAdministration";
    }


    /*---------------------------------------- Edit Customer ----------------------------------------------*/




    @GetMapping("/editCustomer")
    public String editCustomer(Model model, @RequestParam int cusId){
        CustomerDTO customer = customerRepository.read(cusId);
        model.addAttribute("customer", customer);
        return "customer/editCustomer";
    }




    @PostMapping("/editCustomer")
    public String updateCustomer(@ModelAttribute CustomerDTO customer){
        customerRepository.edit(customer);
        return "redirect:/customerAdministration";
    }


}
