package com.pivovarit.rental.api.event;

import java.time.Instant;

public record RentalEvent(Instant timestamp, RentalEventType eventType, String accountId, String movieTitle) {

    public enum RentalEventType {
        RENT, RETURN
    }

}
