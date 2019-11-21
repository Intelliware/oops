package com.intelliware.oops.server.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/accounts")
    public Account getCurrentAccount() {
        return accountService.getCurrentAccount();
    }

}
