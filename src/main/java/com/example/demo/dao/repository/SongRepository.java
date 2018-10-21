package com.example.demo.dao.repository;

import com.example.demo.dao.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long>, QuerydslPredicateExecutor<Song> {
    List<Song> findByTitleLike(String title);

    List<Song> findByArtistId(Long id);

    List<Song> findByArtistName(String name);
}
