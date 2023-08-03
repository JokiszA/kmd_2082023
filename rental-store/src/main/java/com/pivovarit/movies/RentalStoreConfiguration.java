package com.pivovarit.movies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RentalStoreConfiguration {

    @Bean
    public MovieRentalFacade movieService(MovieRepository movieRepository) {
        return new MovieRentalFacade(movieRepository);
    }

    @Bean
    public SpringDataMovieRepositoryAdapter springDataMovieRepositoryAdapter(SpringDataMovieRepository repository) {
        return new SpringDataMovieRepositoryAdapter(repository);
    }
}
