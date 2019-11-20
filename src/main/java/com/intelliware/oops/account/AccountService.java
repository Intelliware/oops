package com.intelliware.oops.account;

import com.intelliware.oops.adapter.AccountAddressAdapter;
import com.intelliware.oops.adapter.AccountBalanceAdapter;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Component
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

    @HystrixCommand(fallbackMethod = "overnightBalance")
    private BigDecimal currentBalance(String accountId) {
        try {
            return accountBalanceAdapter.currentBalance(accountId);
        } catch (RuntimeException e) {
            System.out.println("Exception during current balancae: " + e);
            throw e;
        }
    }

    @HystrixCommand(fallbackMethod = "failedBalanceRequest")
    private BigDecimal overnightBalance(String accountId) {
        return accountBalanceAdapter.overnightBalance(accountId);
    }

    private BigDecimal failedBalanceRequest(String accountId) {
        return null;
    }

    @HystrixCommand(fallbackMethod = "blankAddress")
    private Address currentAddress(String accountId) {
        return accountAddressAdapter.currentAddress(accountId);
    }

    private Address blankAddress(String accountId) {
        return new Address();
    }
}
