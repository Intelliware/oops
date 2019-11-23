package com.intelliware.oops.server.adapter;

import com.intelliware.oops.server.account.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountBalanceAdapterTest {
    @Mock
    CurrentClient currentClient;
    @Mock
    OvernightClient overnightClient;
    @InjectMocks
    AccountBalanceAdapter accountBalanceAdapter;

    private static final String ACCOUNT_ID = "12345";

    @Test
    public void currentBalance() {
        BigDecimal balance = new BigDecimal("99.50");
        when(currentClient.getBalance(ACCOUNT_ID)).thenReturn(balance);

        BigDecimal actualBalance = accountBalanceAdapter.currentBalance(ACCOUNT_ID);

        assertThat(actualBalance, equalTo(balance));
    }

    @Test
    public void nightlyBalance() {
        BigDecimal balance = new BigDecimal("2400.99");
        when(overnightClient.getBalance(ACCOUNT_ID)).thenReturn(balance);

        BigDecimal actualBalance = accountBalanceAdapter.overnightBalance(ACCOUNT_ID);

        assertThat(actualBalance, equalTo(balance));
    }

    @Test
    public void missingBalance() {
        BigDecimal actualBalance = accountBalanceAdapter.missingBalance(ACCOUNT_ID);

        assertThat(actualBalance, nullValue());
    }
}
