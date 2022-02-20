package controllers;

import model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.IMusicService;
import service.impl.MusicServiceImpl;

import java.util.List;

@Controller
public class MusicController {
    IMusicService iMusicService = new MusicServiceImpl();
    @GetMapping("/homePage")
    public String returnHomePage(Model model){
        List<Music> musicList =  iMusicService.getAllMusic();
        model.addAttribute("musicList",musicList);
        return "homePage";
    }
    @GetMapping("/homeCreate")
    public String homeCreate(Model model){
        Music music = new Music();
        model.addAttribute("music",music);
        return "homeCreate";
    }
    @PostMapping("/homePage")
    public String saveMusic(@ModelAttribute (name = "music") Music musicNew){
        iMusicService.saveMusic(musicNew);
        return "homePage";
    }
}

