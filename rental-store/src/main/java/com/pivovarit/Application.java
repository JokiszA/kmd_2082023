package com.pivovarit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
1. Stworzyli nowy serwis "movie-descriptions"
2. HTTP GET /movie-descriptions/{id} i ma zwracać JSON {"description": "lorem ipsum"}
3. Wszystkie endpointy rental-store'a mają zwracać movie rozszerzony o opis
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
