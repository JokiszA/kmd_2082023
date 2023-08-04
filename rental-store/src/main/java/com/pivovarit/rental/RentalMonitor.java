package com.pivovarit.rental;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
class RentalMonitor {

    private final RentalRepository rentalRepository;

    @Scheduled(cron = "* * * * * *")
    public void rentalMonitoring() {
        var rentals = rentalRepository.findAll();
        if (!rentals.isEmpty()) {
            var history = new StringJoiner("\n", "\n", "");
            for (int i = 0; i < rentals.size(); i++) {
                history.add(i + ": " + rentals.get(i));
            }
            log.info("Rental history: {}", history);
        }
    }
}
