package com.intelliware.oops.server.adapter;

import com.intelliware.oops.server.account.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "address", url = "http://localhost:8081")
public interface AddressClient {
    @RequestMapping("/address/{accountId}")
    Address getAddress(@PathVariable("accountId") String accountId);
}
