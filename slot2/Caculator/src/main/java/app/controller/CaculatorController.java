package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/Calculator")
    public String doCaculator(Model model, @RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam("action") String action) {
        double result = 0;
        switch (action) {
            case "add":
                result = num1 + num2;
                model.addAttribute("result", result);
                return "index";
            case "sub":
                result = num1 - num2;
                model.addAttribute("result", result);
                return "index";
            case "mul":
                result = num1 * num2;
                model.addAttribute("result", result);
                return "index";
            case "div":
                if (num2 == 0) {
                    model.addAttribute("result", "Không thể chia với 0");
                    return "index";
                } else {
                    result = num1 / num2;
                    model.addAttribute("result", result);
                    return "index";

                }


        }
        return "index";
    }
}
