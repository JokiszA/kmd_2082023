package com.pivovarit.rental;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
class RentalMonitor {

    private final RentalRepository rentalRepository;

    @Scheduled(cron = "* * * * * 0")
    public void rentalMonitoring() {
        List<Rental> rentals = rentalRepository.findAll();
        if (rentals.isEmpty()) {
            return;
        }
        AtomicInteger counter = new AtomicInteger();
        String history = rentals.stream()
          .map(e -> counter.getAndIncrement() + ": " + e)
          .collect(Collectors.joining("\n"));
        log.info("Rental history: {}", history);
    }
}
