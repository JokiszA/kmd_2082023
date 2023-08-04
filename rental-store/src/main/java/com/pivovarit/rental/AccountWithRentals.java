package com.pivovarit.rental;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@RequiredArgsConstructor
class AccountWithRentals {

    private final String accountId;

    private final List<String> currentlyRented = new ArrayList<>();

    void process(Rental rental) {
        switch (rental.type()) {
            case RETURN -> currentlyRented.remove(rental.movieTitle());
            case RENT -> currentlyRented.add(rental.movieTitle());
        }
    }

    String getAccountId() {
        return accountId;
    }

    int currentRentals() {
        return currentlyRented.size();
    }

    boolean isCurrentlyRented(String movieTitle) {
        return currentlyRented.contains(movieTitle);
    }
}
