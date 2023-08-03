package com.pivovarit.movies;

import com.pivovarit.movies.api.MovieAddRequest;
import com.pivovarit.movies.api.MovieDto;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieRentalFacade {

    private final MovieRepository movieRepository;

    private final MoviePriceCalculator moviePriceCalculator;

    private final MovieDescriptionsRepository movieDescriptionsRepository;

    public Collection<MovieDto> getMovies() {
        return movieRepository.findAll().stream().map(toMovieDto()).collect(Collectors.toList());
    }

    public List<MovieDto> getMoviesByType(MovieType type) {
        return movieRepository.findAllByType(type).stream().map(toMovieDto()).collect(Collectors.toList());
    }

    public Optional<MovieDto> getMovieById(long id) {
        return movieRepository.findOneById(new MovieId(id)).map(toMovieDto());
    }

    public void addMovie(MovieAddRequest movieAddRequest) {
        movieRepository.save(MovieConverter.from(movieAddRequest));
    }

    private Function<Movie, MovieDto> toMovieDto() {
        return movie -> MovieConverter.from(movie, movieDescriptionsRepository.getByMovieId(movie.getId()).orElse(null));
    }
}
