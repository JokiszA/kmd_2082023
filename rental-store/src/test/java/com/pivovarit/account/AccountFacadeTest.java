package com.pivovarit.account;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class AccountFacadeTest {

    @RepeatedTest(1000)
    void shouldAssociateAccountIdToUserId() throws Exception {
        AccountFacade instance = instance();

        instance.map(42, "foo");
        assertThat(instance.getAccountId(42)).contains(new Account(42, "foo"));
    }

    private static AccountFacade instance() {
        return new AccountFacade(new InmemoryAccountRepository());
    }
}
