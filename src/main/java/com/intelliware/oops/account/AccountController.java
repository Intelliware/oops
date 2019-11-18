package com.intelliware.oops.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/accounts")
    public Account getCurrentAccount() {
        return accountService.getCurrentAccount();
    }

}
