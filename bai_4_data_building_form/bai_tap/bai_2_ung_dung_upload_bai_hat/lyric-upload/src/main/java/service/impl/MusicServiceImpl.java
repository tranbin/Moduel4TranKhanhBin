package service.impl;

import model.Music;
import service.IMusicService;

import java.util.ArrayList;
import java.util.List;


public class MusicServiceImpl implements IMusicService {
    private static List<Music> musicList;
    static {
        musicList = new ArrayList<>();
        musicList.add(new Music("aaa", "TrungDP", "Da Nang", ".mp3"));
        musicList.add(new Music("aaa", "TrungDP", "Da Nang", ".mp3"));
        musicList.add(new Music("aaa", "TrungDP", "Da Nang", ".mp3"));
        musicList.add(new Music("aaa", "TrungDP", "Da Nang", ".mp3"));
        musicList.add(new Music("aaa", "TrungDP", "Da Nang", ".mp3"));

    }
    @Override
    public List<Music> getAllMusic() {
        return musicList;
    }

    @Override
    public void saveMusic(Music music) {
        musicList.add(music);
    }
}
