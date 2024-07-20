package com.upload.uploadfile.controller;

import com.upload.uploadfile.model.Song;
import com.upload.uploadfile.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class UploadController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listUploadedSongs(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "/list";
    }

    @GetMapping("/create")
    public String showUploadForm(Model model) {
        model.addAttribute("song", new Song());
        return "/upload_form";
    }

    @PostMapping("/create")
    public String uploadSong(@RequestParam("file") MultipartFile file,
                             @ModelAttribute("song") Song song,
                             BindingResult result,
                             Model model) throws IOException {

        if (result.hasErrors()) {
            return "/upload_form";
        }

        if (file.isEmpty()) {
            model.addAttribute("fileError", "Please select a file to upload.");
            return "/upload_form";
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (!fileName.endsWith(".mp3") && !fileName.endsWith(".wav") &&
                !fileName.endsWith(".ogg") && !fileName.endsWith(".mp4")) {
            model.addAttribute("fileError", "Only MP3, WAV, OGG, and M4P files are allowed.");
            return "/upload_form";
        }

        String uploadDir = "uploads/";
        String filePath = uploadDir + fileName;
        song.setFilePath(filePath);
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable("id") int songId, Model model) {
        Optional<Song> song = songService.findById(songId);
        model.addAttribute("song", song);
        return "delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(@RequestParam("id") int songId) {
        songService.remove(songId);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/edit")
    public String editSong(@PathVariable("id") int songId, Model model) {
        Optional<Song> song = songService.findById(songId);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("song") Song song) {
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/view")
    public String viewSong(@PathVariable("id") int songId, Model model) {
        Optional<Song> song = songService.findById(songId);
        model.addAttribute("song", song);
        return "view";
    }



}


