package com.pivovarit.account;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

class JdbcTemplateExamples {

    private final static JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public static void main(String[] args) {
        Account userId = jdbcTemplate.queryForObject("SELECT * FROM accounts a WHERE a.id = ?", toAccount(), "userId");
        List<Account> accounts = jdbcTemplate.query("SELECT * FROM accounts", toAccount());
        int update = jdbcTemplate.update("INSERT INTO accounts(user_id, account_id) VALUES(?, ?)", "param1", "param2");
    }

    private static RowMapper<Account> toAccount() {
        return (rs, __) -> new Account(rs.getLong("user_id"), rs.getString("account_id"));
    }
}
