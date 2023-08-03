package com.pivovarit.movies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
class RentalStoreDevConfiguration {

    @Bean
    @Profile("dev")
    @Primary
    public MoviePriceCalculator fixedMoviePriceCalculator() {
        return movie -> 42;
    }

    @Bean
    @Profile("dev")
    @Primary
    public MovieRepository inmemoryMovieRepository() {
        return new InmemoryMovieRepository();
    }
}
