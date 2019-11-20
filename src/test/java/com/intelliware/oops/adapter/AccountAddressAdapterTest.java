package com.intelliware.oops.adapter;

import com.intelliware.oops.account.Address;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountAddressAdapterTest {
    @Test
    public void currentAddress() {
        AccountAddressAdapter adapter = new AccountAddressAdapter();

        Address address = adapter.currentAddress("12345678");

        Assertions.assertThat(address).isNotNull();
        Assertions.assertThat(address.getLine()).isNotNull();
    }
}
