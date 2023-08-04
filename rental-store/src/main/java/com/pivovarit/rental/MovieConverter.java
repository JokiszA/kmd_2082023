package com.pivovarit.rental;

import com.pivovarit.rental.api.MovieAddRequest;
import com.pivovarit.rental.api.MovieDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class MovieConverter {

    public static Movie from(PersistedMovie movie) {
        return new Movie(new MovieId(movie.getId()), movie.getTitle(), MovieType.valueOf(movie.getType()));
    }

    public static Movie from(MovieAddRequest request) {
        return new Movie(
          new MovieId(request.getId()),
          request.getTitle(),
          MovieType.valueOf(request.getType()));
    }

    public static MovieDto from(Movie request, MovieDescriptionsRepository.MovieDescription description) {
        return new MovieDto(
          request.getId().getId(),
          request.getTitle(),
          request.getType().toString(),
          description.description());
    }

    public static PersistedMovie toPersistedMovie(Movie movie) {
        return new PersistedMovie(movie.getId().getId(), movie.getTitle(), movie.getType().toString());
    }
}
