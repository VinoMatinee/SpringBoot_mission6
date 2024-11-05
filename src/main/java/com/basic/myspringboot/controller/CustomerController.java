package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.Customer;
import com.basic.myspringboot.exception.BusinessException;
import com.basic.myspringboot.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow(()->new BusinessException("Customer Not Found",HttpStatus.NOT_FOUND));
    }

    @GetMapping("/age/{age}/")
    public List<Customer> getCustomersByAge(@PathVariable Long age){
        return customerRepository.findByAge(age);
    }

    @GetMapping("/email/{email}/")
    public Customer getCustomersByEmail(@PathVariable String email){
        return customerRepository.findByEmail(email).orElseThrow(()->new BusinessException("Customer Not Found",HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/email/{email}/")
    public Customer updateCustomer(@PathVariable String email, @RequestBody Customer detail){
        Customer existUser = customerRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Customer Not Found", HttpStatus.NOT_FOUND));

        existUser.setAge(detail.getAge());
        return customerRepository.save(existUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(()->new BusinessException("Customer Not Found",HttpStatus.NOT_FOUND));
        customerRepository.delete(customer);
        return ResponseEntity.ok("delete customer success");
    }

}
