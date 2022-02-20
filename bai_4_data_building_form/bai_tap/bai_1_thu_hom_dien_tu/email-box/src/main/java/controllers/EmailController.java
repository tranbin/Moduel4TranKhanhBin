package controllers;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {
    @RequestMapping("/create")
    public String create(Model model){
        Email email = new Email();
        model.addAttribute("email",email);
        return "create";
    }
    @RequestMapping("/home")
    public String submit(@ModelAttribute(name = "email")Email newEmail){
        return "save";
    }
/*    EmailService emailService = new EmailService();
    @GetMapping("/save")
    public String getListEmail(Model model){
        List<Email> emailList = emailService.getAllEmail();
        model.addAttribute("emailList", emailList);
        return "save";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Email email = new Email();
        model.addAttribute("email",email);
        return "index";
    }
    @PostMapping("/create")
    public String saveEmail(@ModelAttribute(name = "email") Email emailNew) {
        emailService.saveEmail(emailNew);
        return "save";
    }*/

}
