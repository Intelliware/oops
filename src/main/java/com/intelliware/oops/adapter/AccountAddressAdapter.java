package com.intelliware.oops.adapter;

import com.intelliware.oops.account.Address;
import org.springframework.stereotype.Service;

/**
 * Lookup address associated with account.
 * Would be a call to another network service, but for this project
 * make up an address
 */
@Service
public class AccountAddressAdapter {

    public Address currentAddress(String accountId) {
        // Pretend to call some external service and return the result....
        Address address = new Address();
        address.setLine(""+accountId+" Home St");
        address.setTown("Some Place");
        address.setCountry("Canada");
        return address;
    }
}
