package music.service.impl;

import music.model.Music;
import music.repository.MusicRepository;
import music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void remove(int id) {
        musicRepository.remove(id);
    }
}
