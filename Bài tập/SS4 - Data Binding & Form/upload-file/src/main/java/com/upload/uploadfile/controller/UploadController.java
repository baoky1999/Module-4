package com.upload.uploadfile.controller;

import com.upload.uploadfile.model.Song;
import com.upload.uploadfile.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class UploadController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public String showUploadForm(Model model) {
        model.addAttribute("song", new Song());
        return "upload_form";
    }

    @PostMapping("/upload_form")
    public String uploadSong(@RequestParam("file") MultipartFile file,
                             @ModelAttribute("song") Song song,
                             BindingResult result,
                             Model model) throws IOException {

        if (result.hasErrors()) {
            return "upload_form";
        }

        if (file.isEmpty()) {
            model.addAttribute("fileError", "Please select a file to upload.");
            return "upload_form";
        }

        // Validate file extension
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (!fileName.endsWith(".mp3") && !fileName.endsWith(".wav") &&
                !fileName.endsWith(".ogg") && !fileName.endsWith(".mp4")) {
            model.addAttribute("fileError", "Only MP3, WAV, OGG, and M4P files are allowed.");
            return "upload_form";
        }

        // Save file to disk (you can customize this part)

        // Save song information to database
        String uploadDir = "uploads/";
        String filePath = uploadDir + fileName;
        song.setFilePath(filePath);
        songRepository.save(song);

        // Redirect to list of uploaded songs
        return "redirect:/songs/listsong";
    }

    @GetMapping("/listsong")
    public String listUploadedSongs(Model model) {
        List<Song> songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    // Other methods as needed
}


