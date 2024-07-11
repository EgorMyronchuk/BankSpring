package service;

import dao.AccountDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountSevice {

    private final AccountDao accountDao;
}
