package com.pivovarit.movies;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MovieRentalFacade {

    private final MovieRepository movieRepository;

    private final MoviePriceCalculator moviePriceCalculator;

    public Collection<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByType(MovieType type) {
        return movieRepository.findAllByType(type);
    }

    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findOneById(new MovieId(id));
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
