package controllers;

import lombok.RequiredArgsConstructor;
import model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    private final static ResponseEntity<Account> emptyBook =
            ResponseEntity.notFound().build();

    @PostMapping("deposit")
    public ResponseEntity<?> deposit (String cardNumber , Double amount) {
      Optional<Account> account = accountService.deposit(cardNumber , amount);

      if (account.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(account.get());
      else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card by this number not find");
    }

    @PostMapping("withdraw")
    public ResponseEntity<?> withdraw (String cardNumber , Double amount) {
        Optional<Account> account = accountService.withdraw(cardNumber , amount);

        if (account.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(account.get());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card by this number not find");
    }

    @PostMapping("transfer")
    public ResponseEntity<?> transfer (String cardNumberFrom , String cardNumberTo , Double amount) {
        Optional<List<Account>> account = accountService.transfer(cardNumberFrom, cardNumberTo , amount);
        if (account.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(account.get());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card by this number not find or Not enough money to transfer");
    }


}
