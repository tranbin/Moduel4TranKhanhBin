package service;

import model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAllMusic();
    void saveMusic(Music music);
}
