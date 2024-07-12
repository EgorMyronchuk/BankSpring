package service;

import dao.AccountDao;
import lombok.RequiredArgsConstructor;
import model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDao accountDao;

    public Optional<Account> deposit(String accountNumber , Double amount) {
        Optional<Account> account = accountDao.findAll()
                .stream()
                .filter(x -> x.getNumber().equals(accountNumber))
                .findFirst();

        if (account.isPresent()) {
            Double balance = account.get().getBalance();
            account.get().setBalance(balance + amount);
            accountDao.save(account.get());
        }
        else ()


    }




}