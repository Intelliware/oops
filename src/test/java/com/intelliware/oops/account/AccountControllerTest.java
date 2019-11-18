package com.intelliware.oops.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountControllerTest {
    @Test
    public void getCurrentAccount() {
        AccountController accountController = new AccountController();

        Account account = accountController.getCurrentAccount();

        Assertions.assertThat(account).isNotNull();
        Assertions.assertThat(account.getCardNumber()).isEqualTo("123456789");
    }
}
