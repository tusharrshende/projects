package com.geekster.MusicAPI.controllers;

import com.geekster.MusicAPI.models.Admin;
import com.geekster.MusicAPI.models.Music;
import com.geekster.MusicAPI.services.AdminService;
import com.geekster.MusicAPI.services.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MusicService musicService;

    @GetMapping("/getAllMusicById/{id}")
    public Optional<Music> getAllMusic(@PathVariable Integer id){
       return musicService.getMusicById(id);
    }

    @PutMapping("/update/{id}")
    public void updateMusic(@PathVariable Integer id,@RequestBody Music music){
        musicService.updateMusic(id,music);
    }

}
