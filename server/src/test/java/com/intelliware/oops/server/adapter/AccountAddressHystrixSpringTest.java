package com.intelliware.oops.server.adapter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import com.intelliware.oops.server.account.Address;
import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.Hystrix;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountAddressHystrixSpringTest {

    @MockBean
    private AddressClient addressClient;

    @Autowired
    private AccountAddressAdapter accountAddressAdapter;

    private static final String ACCOUNT_ID = "12345";
    private static final String TORONTO = "Toronto";

    @Before
    public void setup() {
        resetHystrix();
    }

    @Test
    public void currentAddressFromClient() {
        Address address = withTorontoAddress();
        when(addressClient.getAddress(ACCOUNT_ID)).thenReturn(address);

        Address actualAddress = accountAddressAdapter.currentAddress(ACCOUNT_ID);

        assertThat(actualAddress, is(address));
        assertThat(actualAddress.getTown(), equalTo(TORONTO));
    }

    @Test
    public void currentAddressFallsbackToBlankAddress() {
        Address address = withTorontoAddress();
        when(addressClient.getAddress(ACCOUNT_ID)).thenThrow(new RuntimeException("client failed"));

        Address actualAddress = accountAddressAdapter.currentAddress(ACCOUNT_ID);

        assertThat(actualAddress, notNullValue());
        assertThat(actualAddress.getTown(), not(equalTo(TORONTO)));
    }

    private Address withTorontoAddress() {
        Address address = new Address();
        address.setTown(TORONTO);
        return address;
    }

    private void resetHystrix() {
        Hystrix.reset();
    }
}
