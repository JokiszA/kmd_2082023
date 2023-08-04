package com.pivovarit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * EVENT SOURCING
 *
 * 1. HTTP POST /movies/rent { "accountId": "foo", "title":"Spiderman" }
 * 2. HTTP POST /movies/return { "accountId": "foo", "title":"Spiderman" }
 * 3. Zapisujemy w tabeli movie-rental-history, która ma kolumny: id, event type, account id, title
 * Potem: nie można wypożyczyć więcej niż 10 filmów
 *
 */
@EnableScheduling
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
