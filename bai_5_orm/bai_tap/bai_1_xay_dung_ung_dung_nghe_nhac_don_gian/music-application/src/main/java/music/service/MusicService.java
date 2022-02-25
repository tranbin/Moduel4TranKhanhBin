package music.service;

import music.model.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    Music findById(int id);

    void save(Music music);

    void remove(int id);
}
