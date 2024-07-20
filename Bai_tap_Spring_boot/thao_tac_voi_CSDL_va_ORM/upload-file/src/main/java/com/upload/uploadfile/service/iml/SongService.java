package com.upload.uploadfile.service.iml;

import com.upload.uploadfile.model.Song;
import com.upload.uploadfile.repository.SongRepository;
import com.upload.uploadfile.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void remove(int songId) {
        songRepository.deleteById((long) songId);
    }

    @Override
    public Optional<Song> findById(int songId) {
        return songRepository.findById((long) songId);
    }
}
