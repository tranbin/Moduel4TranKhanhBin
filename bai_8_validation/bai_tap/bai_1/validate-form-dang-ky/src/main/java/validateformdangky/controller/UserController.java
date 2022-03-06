package validateformdangky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import validateformdangky.model.User;
import validateformdangky.service.impl.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public ModelAndView getIndex() {
        return new ModelAndView("index", "users", userService.findAll());
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        } else {
            userService.saveUser(user);
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("user", new User());
            modelAndView.addObject("message", "New User create successfully");
            return modelAndView;
        }
    }

}
