package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public ModelAndView getAllStudent(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        List<Customer> customer = customerService.findAll();
        modelAndView.addObject("customers", customer);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        customerService.save(customer);
        modelAndView.addObject("mess", "Tao moi thanh cong");
        return modelAndView;


    }

}
