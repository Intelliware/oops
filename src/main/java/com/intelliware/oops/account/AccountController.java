package com.intelliware.oops.account;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class AccountController {

    @RequestMapping("/accounts")
    public Account getCurrentAccount() {
        Account account = new Account();
        account.setCardNumber("123456789");

        return account;
    }

}
