package com.intelliware.oops.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountServiceTest {
    @Test
    public void getCurrentAccount() {
        AccountService accountController = new AccountService();

        Account account = accountController.getCurrentAccount();

        Assertions.assertThat(account).isNotNull();
        Assertions.assertThat(account.getCardNumber()).isEqualTo("123456789");
    }
}
