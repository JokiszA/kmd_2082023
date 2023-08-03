package com.pivovarit.account;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class InmemoryAccountRepository implements AccountRepository {

    private final Map<Long, String> accounts = new ConcurrentHashMap<>();

    @Override
    public void associate(long userId, String accountId) {
        accounts.put(userId, accountId);
    }

    @Override
    public Optional<String> getAccountId(long userId) {
        return Optional.ofNullable(accounts.get(userId));
    }

    @Override
    public String remove(long userId) {
        return accounts.remove(userId);
    }
}
