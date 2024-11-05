package com.basic.myspringboot.controller;

import com.basic.myspringboot.dto.req.CustomerReqDto;
import com.basic.myspringboot.dto.req.CustomerReqForm;
import com.basic.myspringboot.dto.res.CustomerRespDto;
import com.basic.myspringboot.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerThymeleafController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/index")
    public ModelAndView myIndex(Model model) {
        List<CustomerRespDto> customerList = customerService.fetchCustomers();
//        model.addAttribute("customers", customerList);
//        return "index";
        return new ModelAndView("index", "customers", customerList);
    }

    @GetMapping("/signup")
    public String showAddForm(@ModelAttribute("customer") CustomerReqDto customerReqDto) {
        return "add-customer";
    }

    @PostMapping("/addcustomer")
    public String addCustomer(@Valid @ModelAttribute("customer") CustomerReqDto customerReqDto,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "add-customer";
        }
        customerService.makeCustomer(customerReqDto);
        return "redirect:/customers/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateFrom(@PathVariable Long id, Model model) {
        CustomerRespDto customerRespDto = customerService.fetchCustomer(id);
        model.addAttribute("customer", customerRespDto);
        return "update-customer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@Valid @ModelAttribute("customer") CustomerReqForm customerReqForm,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "update-customer";
        }
        customerService.changeUpdateForm(customerReqForm);
        return "redirect:/customers/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.removeCustomer(id);
        return "redirect:/customers/index";
    }

}