package music_validate_form.controller;

import music_validate_form.model.Music;
import music_validate_form.service.impl.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MusicController {
    @Autowired
    private MusicServiceImpl musicService;

    @GetMapping("")
    public ModelAndView getHomePage() {
        return new ModelAndView("index", "musics", musicService.findAll());
    }

    @GetMapping("/create-music")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "music", new Music());
    }

    @PostMapping("/create-music")
    public ModelAndView saveMusic(@Validated @ModelAttribute(name = "music") Music music, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        } else {
            musicService.saveMusic(music);
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("music", new Music());
            modelAndView.addObject("message", "Music song create successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit-music/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Music music = musicService.findMusicById(id);
        if (music != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("music", music);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }

    }
    @PostMapping("edit-music")
    public ModelAndView updateMusic(@Validated @ModelAttribute ("music")Music music,BindingResult bindingResult ){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("edit");
        }else {
            musicService.saveMusic(music);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("music", new Music());
            modelAndView.addObject("message", "Music song update successfully");
            return modelAndView;
        }
    }
}