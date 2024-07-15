package controllers;

import lombok.RequiredArgsConstructor;
import model.Account;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

import java.util.Currency;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping
    public Customer getCustomerById(Long id) {

    }
    @GetMapping
    public List<Customer> getAllCustomers() {

    }
    @PostMapping
    public void saveCustomer(Customer customer) {

    }
    @PutMapping
    public void changeCustomer(Customer customer) {

    }
    @DeleteMapping
    public void deleteCustomer(Long id) {

    }
    PostMapping
    public void createAccountForCustomer(Long id , Currency currency) {

    }
    PostMapping
    public void deleteAccountForCustomer(Long id , Account account ) {
       ]
    }




}
