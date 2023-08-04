package com.pivovarit.rental;

import com.pivovarit.rental.api.MovieAddRequest;
import com.pivovarit.rental.api.MovieDto;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MovieRentalFacadeUnitTest {

    private static final String FIXED_MOVIE_DESCRIPTION = "foo";

    @Test
    void should_add_movie() {
        var movie = new MovieAddRequest(42, "spiderman", "NEW");
        var accountFacade = instance();

        accountFacade.addMovie(movie);

        Optional<MovieDto> result = accountFacade.getMovieById(movie.getId());

        assertThat(result.orElseThrow().getId()).isEqualTo(movie.getId());
        assertThat(result.orElseThrow().getTitle()).isEqualTo(movie.getTitle());
        assertThat(result.orElseThrow().getType()).isEqualTo(movie.getType());
        assertThat(result.orElseThrow().getDescription()).isEqualTo(FIXED_MOVIE_DESCRIPTION);
    }

    private static MovieRentalFacade instance() {
        return new MovieRentalFacade(new InmemoryMovieRepository(), new TypeBasedMoviePriceCalculator(1, 2, 3), id -> Optional.of(new MovieDescriptionsRepository.MovieDescription(FIXED_MOVIE_DESCRIPTION)), new InmemoryRentalRepository());
    }
}
