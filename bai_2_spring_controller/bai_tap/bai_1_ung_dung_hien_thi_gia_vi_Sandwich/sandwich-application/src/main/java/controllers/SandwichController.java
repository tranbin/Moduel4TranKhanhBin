package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam("choose") String[] choose, ModelMap modelMap) {
        modelMap.addAttribute("choose", choose);
        return "index";
    }
}

