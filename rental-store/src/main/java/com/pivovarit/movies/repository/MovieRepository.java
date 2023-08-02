package com.pivovarit.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieRepository extends JpaRepository<PersistedMovie, Long> {
    List<PersistedMovie> findAllByType(String type);
}
