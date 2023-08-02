package com.pivovarit.movies.service;

import com.pivovarit.movies.domain.Movie;
import com.pivovarit.movies.domain.MovieId;
import com.pivovarit.movies.domain.MovieType;
import com.pivovarit.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Collection<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByType(MovieType type) {
        return getMovies().stream().filter(m -> m.getType() == type).collect(Collectors.toList());
    }

    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findById(new MovieId(id));
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
