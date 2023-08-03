package com.pivovarit.movies;

import java.util.Optional;

interface MovieDescriptionsRepository {
    Optional<MovieDescription> getByMovieId(MovieId id);

    record MovieDescription(String description) {
    }
}
