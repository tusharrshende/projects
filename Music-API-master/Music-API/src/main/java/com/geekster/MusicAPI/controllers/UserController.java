package com.geekster.MusicAPI.controllers;

import com.geekster.MusicAPI.dto.SignInInput;
import com.geekster.MusicAPI.dto.SignInOutput;
import com.geekster.MusicAPI.dto.SignUpOutput;
import com.geekster.MusicAPI.models.Music;
import com.geekster.MusicAPI.models.User;
import com.geekster.MusicAPI.services.MusicService;
import com.geekster.MusicAPI.services.TokenService;
import com.geekster.MusicAPI.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    MusicService musicService;
    @Autowired
    TokenService authService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @PostMapping("/addMusic")
    public ResponseEntity<String> addMusic(@Valid @RequestParam String email, @RequestParam String token, @RequestBody List<Music> music){
        HttpStatus status;
        String msg="";
        if(authService.authenticate(email,token)){
            User user =  authService.findUserByToken(token);

        List<Music> musicList=music;
        for(Music mu:musicList) {
            mu.setUser(user);
            musicService.addMusic(mu);
        }

            msg = " music added successfully";
            status = HttpStatus.OK;
        }else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(msg , status);
    }

    @GetMapping
    public ResponseEntity<List<Music>> grtMusicPlayList(@RequestParam String email,@RequestParam String token){
        HttpStatus status;
        List<Music> musicList=null;
        if(authService.authenticate(email,token)){
            musicList=musicService.getAllMusic(token);
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Music>>(musicList , status);
    }


}
