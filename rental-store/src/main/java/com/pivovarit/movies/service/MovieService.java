package com.pivovarit.movies.service;

import com.pivovarit.movies.domain.Movie;
import com.pivovarit.movies.domain.MovieType;
import com.pivovarit.movies.mappers.MovieConverter;
import com.pivovarit.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.pivovarit.movies.mappers.MovieConverter.toPersistedMovie;

@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Collection<Movie> getMovies() {
        return movieRepository.findAll().stream().map(MovieConverter::from).collect(Collectors.toList());
    }

    public List<Movie> getMoviesByType(MovieType type) {
        return movieRepository.findAllByType(type.toString()).stream().map(MovieConverter::from)
          .collect(Collectors.toList());
    }

    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findById(id).map(MovieConverter::from);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(toPersistedMovie(movie));
    }
}
