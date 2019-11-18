package com.intelliware.oops.account;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public Account getCurrentAccount() {
        Account account = new Account();
        account.setCardNumber("123456789");

        return account;
    }
}
