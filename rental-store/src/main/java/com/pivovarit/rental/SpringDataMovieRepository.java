package com.pivovarit.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface SpringDataMovieRepository extends JpaRepository<PersistedMovie, Long> {
    List<PersistedMovie> findAllByType(String type);
}
