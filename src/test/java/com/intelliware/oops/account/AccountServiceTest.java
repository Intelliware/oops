package com.intelliware.oops.account;

import com.intelliware.oops.adapter.AccountAddressAdapter;
import com.intelliware.oops.adapter.AccountBalanceAdapter;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

public class AccountServiceTest {

    @Mock
    private AccountAddressAdapter accountAddressAdapter;

    @Mock
    private AccountBalanceAdapter accountBalanceAdapter;

    @InjectMocks
    private AccountService accountService = new AccountService();

    @Test
    public void getCurrentAccount() {

        Account actual = accountService.getCurrentAccount();

        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual.getAccountNumber()).isEqualTo("12345678");
    }
}
