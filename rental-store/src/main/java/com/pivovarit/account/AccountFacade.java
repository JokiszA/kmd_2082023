package com.pivovarit.account;

import java.util.Arrays;
import java.util.List;

public class AccountFacade {

    public void create() {
        System.out.println("creating account");
    }

    public List<String> findAll() {
        System.out.println("creating account");
        return Arrays.asList("a", "b");
    }

    public void delete() {
        System.out.println("deleting account");
    }
}
