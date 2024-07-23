package com.validation.songvalidation.repository;

import com.validation.songvalidation.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
