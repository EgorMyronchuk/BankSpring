package service;

import dao.AccountDao;
import lombok.RequiredArgsConstructor;
import model.Account;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountDao accountDao;

    public Optional<Account> deposit(String accountNumber , Double amount) {
        Optional<Account> account = accountDao.findByNumber(accountNumber);
        if (account.isPresent()) {
            Double balance = account.get().getBalance();
            account.get().setBalance(balance + amount);
            accountDao.save(account.get());
        }
        return account;
    }

    public Boolean withdraw (String accountNumber , Double amount) {
        Function<Account , Boolean> enoughBalance = x -> x.getBalance() >= amount;
        Optional<Account> accountopt = accountDao.findByNumber(accountNumber);
        if (accountopt.isEmpty()) {
            return false;
        }
        Account account = accountopt.get();
        if (enoughBalance.apply(account))  {
            account.setBalance(account.getBalance() - amount);
            accountDao.save(account);
            return true;
        }
        return false;
    }

    public Boolean transfer (String accountFromNumber , String accountToNumber , Double amount) {
        if (accountDao.findByNumber(accountFromNumber).isEmpty() || accountDao.findByNumber(accountToNumber).isEmpty()) {
            return false;
        }
        if (withdraw(accountFromNumber, amount)) {
            deposit(accountToNumber, amount);
            return true;
        }
        return false;
    }
}