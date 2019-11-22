package com.intelliware.oops.server.adapter;

import com.intelliware.oops.server.account.Address;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Lookup address associated with account using core network services.
 */
@Component
public class AccountAddressAdapter {

    @Autowired
    AddressClient addressClient;

    @HystrixCommand(fallbackMethod = "blankAddress")
    public Address currentAddress(String accountId) {
        return addressClient.getAddress(accountId);
    }

    Address blankAddress(String accountId) {
        return new Address();
    }
}
