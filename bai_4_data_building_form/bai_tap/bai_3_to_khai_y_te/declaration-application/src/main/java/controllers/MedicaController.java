package controllers;

import model.MedicaDeclare;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedicaController {
    @GetMapping("/index")
    public String homePage(@ModelAttribute(name = "medica") MedicaDeclare medicaDeclare) {
        return "index";
    }
}

