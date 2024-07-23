package com.validation.songvalidation.controller;


import com.validation.songvalidation.dto.SongDTO;
import com.validation.songvalidation.model.Song;
import com.validation.songvalidation.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/song_validation")
public class UserController {

    @Autowired
    private ISongService songService;

    @GetMapping
    public String showListSong(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "view/home";
    }

    @GetMapping("/create")
    public String showCreateSongForm(Model model) {
        model.addAttribute("songDto", new SongDTO());
        return "view/create";
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute("songDto") SongDTO songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "view/create";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Successfully created song");
        return "redirect:/song_validation";

    }

    @GetMapping("{id}/edit")
    public String showUpdateSongForm(@PathVariable("id") int id, Model model) {
        Optional<Song> song = songService.findById(id);
        SongDTO songDto = new SongDTO();
        BeanUtils.copyProperties(song.get(), songDto);
        model.addAttribute("songDto", songDto);
        return "view/update";
    }

    @PostMapping("{id}/edit")
    public String update(@Validated @PathVariable("id") int id,
                         @ModelAttribute("songDto") SongDTO songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "view/create";
        }
        Song song = new Song();
        song.setId(id);
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Successfully update song");
        return "redirect:/song_validation";
    }


}
