package music_validate_form.service;

import music_validate_form.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void saveMusic(Music music);

    void deleteMusic(int id);

    Music findMusicById(int id);
}
