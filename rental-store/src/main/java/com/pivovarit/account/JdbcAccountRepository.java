package com.pivovarit.account;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
class JdbcAccountRepository implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void associate(long userId, String accountId) {

    }

    @Override
    public Optional<Account> getAccountId(long userId) {

//        List<Account> query = jdbcTemplate.query("SELECT * FROM accounts", toAccount(), userId);
//        jdbcTemplate.update("INSERT INTO accounts(user_id, account_id) VALUES(?, ?)", userId, "asdasd");
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM accounts a WHERE a.id = ?", toAccount(), userId));
    }

    private static RowMapper<Account> toAccount() {
        return (rs, __) -> new Account(rs.getLong("user_id"), rs.getString("account_id"));
    }

    @Override
    public Account remove(long userId) {
        return null;
    }
}
