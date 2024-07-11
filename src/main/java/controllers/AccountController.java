package controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import service.AccountSevice;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountSevice accountService;
}
