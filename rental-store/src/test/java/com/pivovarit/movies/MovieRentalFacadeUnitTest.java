package com.pivovarit.movies;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MovieRentalFacadeUnitTest {

    @Test
    void should_add_movie() {
        var movie = new Movie(new MovieId(42), "spiderman", MovieType.NEW);
        var accountFacade = instance();

        accountFacade.addMovie(movie);

        Optional<Movie> result = accountFacade.getMovieById(movie.getId().getId());

        assertThat(result).contains(movie);
    }

    private static MovieRentalFacade instance() {
        return new MovieRentalFacade(new InmemoryMovieRepository(), new TypeBasedMoviePriceCalculator(1, 2, 3));
    }
}
