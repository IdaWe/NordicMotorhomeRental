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


    @GetMapping("/customerAdministration")
    public String customerAdministration(/*Model model*/){
        /*model.addAttribute("students", studentRepository.readAll());*/
        return "customer/customerAdministration";
    }


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

    @GetMapping("/allCustomers")
    public String allCustomers(Model model){
        model.addAttribute("customers", customerRepository.readAll());
        return "customer/allCustomers";
    }


    @GetMapping("/findCustomer")
    public String findCustomer(Model model){
       // if(model.getAttribute("customer") == null) {
            model.addAttribute("customer", new CustomerDTO());// laver et tomt customer object, det der står i form {customer}
      //  }
        return "customer/findCustomer";
    }



    @PostMapping("/getCustomerById")
    public String getCustomerById(@ModelAttribute CustomerDTO customer,Model model) {
        CustomerDTO cus = customerRepository.read(customer.getCusId());
        model.addAttribute("customer", cus);
        return "customer/findCustomer";
    }

    @GetMapping("/deleteCustomer")
    public String details(Model model, @RequestParam int cusId){
        CustomerDTO cus = customerRepository.read(cusId);
        model.addAttribute("customer", cus);
        return "customer/deleteCustomer";
    }

/*
--- Denne virker også som getmapping til delete customer, hvad er rigtigt?!?!?

    @GetMapping("/deleteCustomer")
    public String deleteStud(@ModelAttribute CustomerDTO customer,Model model){
        CustomerDTO cus = customerRepository.read(customer.getCusId());
        model.addAttribute("customer", cus);
        return "customer/deleteCustomer";
    }
*/






    /*
    @GetMapping("/getCustomerById")
    public String deleteStud(Model model, @RequestParam int cusId){
        CustomerDTO cus = customerRepository.read(cusId);
        model.addAttribute("customer", cus);
        return "customer/deleteCustomer";
    }
/*
    @PostMapping ("student/deleteStudent")
    public String deleteForGood(int id){
        studentRepository.delete(id);
        return "redirect:/overview";
    }



/*

    @PostMapping("/customer/findCustomerById")
    public String findCustomerById(Model model, int search) {
        CustomerDTO cus = customerRepository.read(search);
        model.addAttribute("customer", cus);
        return "redirect:/customer/findCustomerById";
    }


   /* @PostMapping("/grocery/addGrocery")
    public String addGrocery(@ModelAttribute Grocery groceryFromPost, Model model) {
        fakeDatabase.add(groceryFromPost);
        groceryFromPost.getPrisGangeAntal();
        //System.out.println(groceryFromPost);
        return "redirect:/grocery/overview";
    }



/*
    @GetMapping("/findCustomer")
    public String findCustomer(@RequestParam (value = "cusId") int cusId, Model model) {
        model.addAttribute("customer", customerRepository.read(cusId));
        return "customer/findCustomer";
    }


    @GetMapping("/findCustomer")
    public String findCustomer(Model model){
        model.addAttribute("customer", customerRepository.read());
        return "customer/findCustomer";
    }

    @PostMapping("/findCustomer")
    public String findCustomerById(@ModelAttribute CustomerDTO customerDTO){
        customerRepository.create(customerDTO);
        return "redirect:/customerAdministration";
    }*/


}
