package com.upload.uploadfile.service;

import com.upload.uploadfile.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    void save(Song song);

    List<Song> findAll();

    void remove(int songId);

    Optional<Song> findById(int songId);
}
