package com.pivovarit.rental;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.Optional;

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

    @Bean
    @Profile("dev")
    @Primary
    public MovieDescriptionsRepository movieDescriptionsRepository() {
        return id -> Optional.of(new MovieDescriptionsRepository.MovieDescription("lorem ipsum"));
    }

    @Bean
    @Profile("dev")
    @Primary
    public RentalRepository inmemoryRentalRepository() {
        return new InmemoryRentalRepository();
    }


    @Bean
    @Profile("dev")
    @Primary
    public MessagePublisher inmemoryMessagePublisher() {
        return new InmemoryMessagePublisher();
    }
}
