package com.pivovarit.rental;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
class RentalStoreConfiguration {

    @Bean
    public MoviePriceCalculator moviePriceCalculator() {
        return new TypeBasedMoviePriceCalculator(10, 6, 8);
    }

    @Bean
    public MovieRentalFacade movieService(MovieRepository movieRepository, MoviePriceCalculator moviePriceCalculator, MovieDescriptionsRepository movieDescriptionsRepository, RentalRepository rentalRepository, MessagePublisher messagePublisher) {
        return new MovieRentalFacade(movieRepository, moviePriceCalculator, movieDescriptionsRepository, rentalRepository, messagePublisher);
    }

    @Bean
    @Profile("default")
    public MovieRepository jdbcMovieRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcMovieRepository(jdbcTemplate);
    }

    @Bean
    @Profile("default")
    public MovieDescriptionsRepository movieDescriptionsRepository(@Value("${rental.movie-descriptions-service.url}") String url, RestTemplateBuilder restTemplate) {
        return new HttpMovieDescriptionsRepository(url, restTemplate.build());
    }

    @Bean
    @Profile("default")
    public MovieDetailsServiceHealthCheck movieDetailsServiceHealthCheck(@Value("${rental.movie-descriptions-service.url}") String url, RestTemplateBuilder restTemplate) {
        return new MovieDetailsServiceHealthCheck(url, restTemplate.build());
    }

    @Bean
    public RentalMonitor rentalMonitor(RentalRepository rentalRepository) {
        return new RentalMonitor(rentalRepository);
    }

    @Bean
    @Profile("default")
    public RentalRepository inmemoryRentalRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcRentalRepository(jdbcTemplate);
    }

    @Bean
    @Profile("default")
    public MessagePublisher rmqMessagePublisher(RabbitTemplate rabbitTemplate) {
        return new RabbitMQMessagePublisher(rabbitTemplate);
    }

    /*
    @Bean
    @Profile("default")
    public SpringDataMovieRepositoryAdapter springDataMovieRepositoryAdapter(SpringDataMovieRepository repository) {
        return new SpringDataMovieRepositoryAdapter(repository);
    }*/
}
