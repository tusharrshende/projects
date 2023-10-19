package com.geekster.MusicAPI.services;

import com.geekster.MusicAPI.models.Music;
import com.geekster.MusicAPI.models.User;
import com.geekster.MusicAPI.repository.IMusicRepo;
import com.geekster.MusicAPI.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
    @Autowired
    IMusicRepo musicRepo;
    @Autowired
    ITokenRepo tokenRepo;
    public void addMusic(Music mu) {
        musicRepo.save(mu);
    }

    public List<Music> getAllMusic(String token) {
        User user = tokenRepo.findFirstByToken(token).getUser();
        List<Music> musicList=musicRepo.findByUser(user);
        return musicList;
    }


    public Optional<Music> getMusicById(Integer id) {
        return musicRepo.findById(id);
    }

    public void updateMusic(Integer id, Music music) {
        Music mu=musicRepo.findMusicByMusicId(id);
        User user=mu.getUser();
        music.setUser(user);
        musicRepo.deleteById(id);
        musicRepo.save(music);
    }
}
