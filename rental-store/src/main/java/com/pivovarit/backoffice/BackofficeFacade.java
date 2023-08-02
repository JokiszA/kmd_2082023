package com.pivovarit.backoffice;

import com.pivovarit.account.AccountFacade;
import com.pivovarit.warehouse.WareHouseFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BackofficeFacade {
    private final AccountFacade account;
    private final WareHouseFacade warehouse;

    public void ensureEnoughStockForAccount(long ig) {

    }
}
