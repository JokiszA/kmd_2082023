package com.pivovarit.rental;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
class CustomHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().build();
    }
}
