package music_validate_form.service.impl;

import music_validate_form.model.Music;
import music_validate_form.repository.IMusicRepository;
import music_validate_form.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void saveMusic(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void deleteMusic(int id) {
        musicRepository.deleteById(id);
    }

    @Override
    public Music findMusicById(int id) {
        return musicRepository.findById(id).orElse(null);
    }
}
