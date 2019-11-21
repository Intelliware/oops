package com.intelliware.oops.server.account;

import com.intelliware.oops.server.adapter.AccountAddressAdapter;
import com.intelliware.oops.server.adapter.AccountBalanceAdapter;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    AccountBalanceAdapter accountBalanceAdapter;

    @Autowired
    AccountAddressAdapter accountAddressAdapter;

    public Account getCurrentAccount() {
        String accountId = "123456789";
        Account account = new Account();
        account.setAccountNumber(accountId);
        account.setCurrentAddress(currentAddress(accountId));
        account.setCurrentBalance(currentBalance(accountId));
        return account;
    }

    private BigDecimal currentBalance(String accountId) {
        return accountBalanceAdapter.currentBalance(accountId);
    }

    private Address currentAddress(String accountId) {
        return accountAddressAdapter.currentAddress(accountId);
    }
}
