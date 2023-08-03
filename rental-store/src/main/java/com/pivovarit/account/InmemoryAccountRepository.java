package com.pivovarit.account;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class InmemoryAccountRepository implements AccountRepository {

    private final Map<Long, Account> accounts = new ConcurrentHashMap<>();

    @Override
    public void associate(long userId, String accountId) {
        accounts.put(userId, new Account(userId, accountId));
    }

    @Override
    public Optional<Account> getAccountId(long userId) {
        return Optional.ofNullable(accounts.get(userId));
    }

    @Override
    public Account remove(long userId) {
        return accounts.remove(userId);
    }
}
