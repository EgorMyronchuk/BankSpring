package controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("Account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    public void balance (String number , Double balance) {
        accountService.deposit(number, balance);
    }
}
