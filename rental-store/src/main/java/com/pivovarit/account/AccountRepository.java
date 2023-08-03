package com.pivovarit.account;

import java.util.Optional;

interface AccountRepository {
    void associate(long userId, String accountId);
    Optional<String> getAccountId(long userId);

    String remove(long userId);
}
