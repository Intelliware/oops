package com.intelliware.oops.core.address;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @RequestMapping("/address/{accountId}")
    public Address getAddress(@PathVariable String accountId) {
        Address address = new Address();
        address.setLine("" + accountId + " Street");
        address.setTown("Toronto");
        address.setCountry("Canada");
        return address;
    }
}
