package service;

import dao.AccountDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDao accountDao;

    public void deposit(String accountNumber , Double amount) {

    }
}