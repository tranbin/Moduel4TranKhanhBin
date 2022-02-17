package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/caculator")
    public String calculate(@RequestParam(name = "choose1", defaultValue = "0") double choose1,
                            @RequestParam(name = "choose2", defaultValue = "0") double choose2,
                            @RequestParam(name = "div", defaultValue = "") String calcul,
                            ModelMap model) {

        double result = 0;
        switch (calcul) {
            case "Addition(+)":
                result = choose1 + choose2;
                calcul = "Addition";
                break;
            case "Subtraction(-)":
                result = choose1 - choose2;
                calcul = "Subtraction";
                break;
            case "Multiplication(X)":
                result = choose1 * choose2;
                calcul = "Multiplication";
                break;
            case "Division(/)":
                result = choose1 / choose2;
                calcul = "Division";
                break;
        }
        model.addAttribute("choose1", choose1);
        model.addAttribute("choose2", choose2);
        model.addAttribute("calcul", calcul);
        model.addAttribute("result", result);
        return "index";
    }
}
