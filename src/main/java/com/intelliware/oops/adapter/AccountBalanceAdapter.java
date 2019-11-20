package com.intelliware.oops.adapter;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Lookup current balance associated with account.
 * Would be a call to another network service, but for this project
 * make up a balance
 */
@Service
public class AccountBalanceAdapter {

    public BigDecimal currentBalance(String accountId) {
        // Pretend to call some external service and return the result....
//        throw new RuntimeException("failed to get current balance!");
        return new BigDecimal("99.00");
    }

    public BigDecimal overnightBalance(String accountId) {
        // Pretend to call some other external service and return the result....
        return new BigDecimal("2400.00");
    }
}
