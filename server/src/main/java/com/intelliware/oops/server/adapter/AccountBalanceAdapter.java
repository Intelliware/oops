package com.intelliware.oops.server.adapter;

import com.intelliware.oops.server.account.Address;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Lookup balance associated with account using core network services.
 */
@Component
public class AccountBalanceAdapter {
    @Autowired
    private CurrentClient currentClient;

    @Autowired
    private OvernightClient overnightClient;

    @HystrixCommand(fallbackMethod = "overnightBalance")
    public BigDecimal currentBalance(String accountId) {
        return currentClient.getBalance(accountId);
    }

    @HystrixCommand(fallbackMethod = "missingBalance")
    public BigDecimal overnightBalance(String accountId) {
        return overnightClient.getBalance(accountId);
    }

    public BigDecimal missingBalance(String accountId) {
        return null;
    }
}
