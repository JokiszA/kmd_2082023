package com.pivovarit.rental;

import com.pivovarit.rental.api.MovieAddRequest;
import com.pivovarit.rental.api.MovieDto;
import com.pivovarit.rental.api.MovieRentRequest;
import com.pivovarit.rental.api.MovieReturnRequest;
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

    public static Rental from(MovieRentRequest request) {
        return new Rental(Rental.RentalType.RENT, request.accountId(), request.movieTitle());
    }

    public static Rental from(MovieReturnRequest request) {
        return new Rental(Rental.RentalType.RETURN, request.accountId(), request.movieTitle());
    }
}
