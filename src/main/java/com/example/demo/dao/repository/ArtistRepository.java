package com.example.demo.dao.repository;

import com.example.demo.dao.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> , QuerydslPredicateExecutor<Artist> {
    List<Artist> findByName(String name);

    List<Artist> findByIsBand(Boolean isBand);

//    List<Artist> findByArtistPropertyAwardsNumberGrea
}
