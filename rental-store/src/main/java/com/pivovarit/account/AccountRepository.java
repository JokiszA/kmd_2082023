package com.pivovarit.account;

import java.util.Optional;

interface AccountRepository {
    void associate(long userId, String accountId);
    Optional<Account> getAccountId(long userId);

    Account remove(long userId);
}
