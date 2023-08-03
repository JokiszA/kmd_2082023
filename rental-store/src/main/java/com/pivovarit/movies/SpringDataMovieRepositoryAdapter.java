package com.pivovarit.movies;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// adapter (hexagonal)
@RequiredArgsConstructor
class SpringDataMovieRepositoryAdapter implements MovieRepository {

    private final SpringDataMovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll().stream().map(MovieConverter::from).collect(Collectors.toList());
    }

    @Override
    public List<Movie> findAllByType(MovieType type) {
        return movieRepository.findAllByType(type.toString()).stream().map(MovieConverter::from)
          .collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findOneById(MovieId id) {
        return movieRepository.findById(id.getId()).map(MovieConverter::from);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(MovieConverter.toPersistedMovie(movie));
    }
}
