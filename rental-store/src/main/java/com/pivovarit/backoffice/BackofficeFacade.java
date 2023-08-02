package com.pivovarit.backoffice;

import com.pivovarit.account.AccountFacade;
import com.pivovarit.movies.MovieRentalFacade;
import com.pivovarit.warehouse.WareHouseFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BackofficeFacade {
    private final AccountFacade account;
    private final WareHouseFacade warehouse;
    private final MovieRentalFacade rental;

    public void ensureEnoughStockForAccount(long ig) {

    }
}
