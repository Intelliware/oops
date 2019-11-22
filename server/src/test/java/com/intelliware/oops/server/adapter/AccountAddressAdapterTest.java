package com.intelliware.oops.server.adapter;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

import com.intelliware.oops.server.account.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountAddressAdapterTest {
    @Mock AddressClient addressClient;
    @InjectMocks AccountAddressAdapter accountAddressAdapter;

    @Test
    public void getAddressForAccountId() {
        Address address = new Address();
        when(addressClient.getAddress("12345")).thenReturn(address);

        Address actualAddress = accountAddressAdapter.currentAddress("12345");

        assertThat(actualAddress, is(address));
    }

}
