package controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import service.CustomerService;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

}
