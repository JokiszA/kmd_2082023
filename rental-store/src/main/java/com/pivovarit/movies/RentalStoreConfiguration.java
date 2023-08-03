package com.pivovarit.movies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class RentalStoreConfiguration {

    @Bean
    public MoviePriceCalculator moviePriceCalculator() {
        return new TypeBasedMoviePriceCalculator(10, 6, 8);
    }

    @Bean
    public MovieRentalFacade movieService(MovieRepository movieRepository, MoviePriceCalculator moviePriceCalculator) {
        return new MovieRentalFacade(movieRepository, moviePriceCalculator);
    }

    @Bean
    @Profile("default")
    public SpringDataMovieRepositoryAdapter springDataMovieRepositoryAdapter(SpringDataMovieRepository repository) {
        return new SpringDataMovieRepositoryAdapter(repository);
    }
}
