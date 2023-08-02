package com.pivovarit.movies;

import com.pivovarit.movies.api.MovieAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// HTTP GET /movies
// HTTP GET /movies/{id}
// HTTP GET /movies?type=NEW
// HTTP POST /movies (tylko logowanie odebranego obiektu)
@RestController
@RequiredArgsConstructor
public class MovieRentalController {

    private final MovieRentalFacade movieService;

    @GetMapping("/movies")
    public List<Movie> movies(@RequestParam(required = false) MovieType type) {
        if (type != null) {
            return movieService.getMoviesByType(type);
        }
        return new ArrayList<>(movieService.getMovies());
    }

    @GetMapping("/movies/{id}")
    public Optional<Movie> movieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }

    /*
    curl --header "Content-Type: application/json" \
  --request POST \
  --data '{ "id":14, "title":"spiderman", "type":"NEW"}' \
 http://localhost:8081/movies
     */

    @PostMapping("/movies")
    public void addMovie(@RequestBody MovieAddRequest dto) {
        movieService.addMovie(MovieConverter.from(dto));
    }
}
