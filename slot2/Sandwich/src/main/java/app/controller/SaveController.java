package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaveController {
    @GetMapping("/save")
    public String doSave(Model model, @RequestParam("condiments") String[] list){
        String result ="";
        for (String s:list){
            result += s + ",";
        }
        model.addAttribute("result",result);
        return "index";
    }
}
