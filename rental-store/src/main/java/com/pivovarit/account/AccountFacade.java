package com.pivovarit.account;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AccountFacade {

    private final AccountRepository accountRepository;

    void map(long userId, String accountId) {
        accountRepository.associate(userId, accountId);
    }

    Optional<String> getAccountId(long userId) {
        return accountRepository.getAccountId(userId);
    }
}
