package app.controller;

import app.entity.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String displayRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("/create")
    public String doRegisterForm(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "index";
        }else {
            userService.add(user);
            return "result";
        }
    }
}
