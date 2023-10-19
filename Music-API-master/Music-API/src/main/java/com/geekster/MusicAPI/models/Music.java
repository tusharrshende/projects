package com.geekster.MusicAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="music_id")
    private Integer musicId;

    @Column(name="name")
    private String musicName;

    @Column(name="artist")
    private String artists;

    @ManyToOne
    @JoinColumn(nullable = false , name = "fk_user_ID")
    private User user;
}
