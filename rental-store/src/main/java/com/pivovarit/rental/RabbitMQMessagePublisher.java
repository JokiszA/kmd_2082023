package com.pivovarit.rental;

import com.pivovarit.rental.api.event.RentalEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RequiredArgsConstructor
class RabbitMQMessagePublisher implements MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(RentalEvent event) {
        rabbitTemplate.convertAndSend("rentals-topic", RentalEvent.class.getCanonicalName(), event);
    }
}
