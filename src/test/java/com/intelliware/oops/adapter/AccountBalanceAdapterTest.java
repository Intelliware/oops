package com.intelliware.oops.adapter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountBalanceAdapterTest {
    @Test
    public void currentBalance() {
        AccountBalanceAdapter adapter = new AccountBalanceAdapter();

        BigDecimal balance = adapter.currentBalance("12345678");

        Assertions.assertThat(balance).isNotNull();
    }
}
