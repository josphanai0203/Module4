package app.controller;

import app.entity.Feedback;
import app.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImgController {
    @Autowired
    FeedbackService feedbackService;
    @GetMapping("")
    public String getDefault(Model model){
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("list", feedbackService.findAll());
        return "index";
    }
    @PostMapping("/rate")
    public String PostRate(@ModelAttribute Feedback feedback){
        feedbackService.save(feedback);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String GetUpdate(Model model){
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("list", feedbackService.findAll());
        return "index";
    }
    @GetMapping("/updateLike")
    public String GetUpdate(@RequestParam long id){
        feedbackService.likeAction(id);
        return "redirect:/index";
    }
}
