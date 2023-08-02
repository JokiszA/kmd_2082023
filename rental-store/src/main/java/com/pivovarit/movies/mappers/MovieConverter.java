package com.pivovarit.movies.mappers;

import com.pivovarit.movies.api.MovieAddRequest;
import com.pivovarit.movies.domain.Movie;
import com.pivovarit.movies.domain.MovieId;
import com.pivovarit.movies.domain.MovieType;
import com.pivovarit.movies.repository.PersistedMovie;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static Movie from(PersistedMovie movie) {
        return new Movie(new MovieId(movie.getId()), movie.getTitle(), MovieType.valueOf(movie.getType()));
    }

    public static Movie from(MovieAddRequest request) {
        return new Movie(
          new MovieId(request.getId()),
          request.getTitle(),
          MovieType.valueOf(request.getType()));
    }

    public static PersistedMovie toPersistedMovie(Movie movie) {
        return new PersistedMovie(movie.getId().getId(), movie.getTitle(), movie.getType().toString());
    }
}
