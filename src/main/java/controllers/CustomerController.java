package controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CustomerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;






}
