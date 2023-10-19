package com.geekster.MusicAPI.repository;

import com.geekster.MusicAPI.models.Music;
import com.geekster.MusicAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMusicRepo extends JpaRepository<Music,Integer> {
    List<Music> findByUser(User user);


    Music findMusicByMusicId(Integer id);
}
