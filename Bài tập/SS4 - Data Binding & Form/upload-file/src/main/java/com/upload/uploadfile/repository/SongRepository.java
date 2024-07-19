package com.upload.uploadfile.repository;

import com.upload.uploadfile.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}

