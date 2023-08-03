package com.pivovarit.movies;

import com.pivovarit.movies.api.MovieAddRequest;
import com.pivovarit.movies.api.MovieDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieControllerIntegrationTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    MovieRepository movieRepository;

    @Test
    @DirtiesContext
    void should_get_movie_by_id() {
        movieRepository.save(new Movie(new MovieId(1), "spiderman", MovieType.OLD));
        ResponseEntity<MovieDto> forEntity = restTemplate.getForEntity("http://localhost:{port}/movies/1", MovieDto.class, port);

        System.out.println(forEntity.getBody());
    }

    @Test
    @DirtiesContext
    void should_add_movie() {
        var movie = new MovieAddRequest(42, "Tenet", "NEW");
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:{port}/movies", movie, String.class, port);
        ResponseEntity<List<MovieDto>> allMovies = restTemplate.exchange("http://localhost:{port}/movies", HttpMethod.GET, RequestEntity.EMPTY, new ParameterizedTypeReference<>() {
        }, port);

        assertThat(allMovies.getBody()).isNotEmpty();
    }

    @Test
    @DirtiesContext
    void should_get_all_movies() {
        movieRepository.save(new Movie(new MovieId(1), "spiderman", MovieType.OLD));
        movieRepository.save(new Movie(new MovieId(2), "spiderman 2", MovieType.REGULAR));
        ResponseEntity<List<MovieDto>> forEntity = restTemplate.exchange("http://localhost:{port}/movies", HttpMethod.GET, RequestEntity.EMPTY, new ParameterizedTypeReference<>() {
        }, port);

        System.out.println(forEntity.getBody());
    }
}
