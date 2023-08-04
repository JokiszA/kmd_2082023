package com.pivovarit.rental;

import com.pivovarit.rental.api.event.RentalEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
class InmemoryMessagePublisher implements MessagePublisher {

    private final List<RentalEvent> publishedEvents = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void publish(RentalEvent event) {
        System.out.println("Publishing " + event);
        publishedEvents.add(event);
    }
}
