package app.controller;

import app.service.CategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryBlogService categoryBlogService;
    @GetMapping("/category/list")
    public String displayCategoru(Model model){
        model.addAttribute("list",categoryBlogService.findAll());
        return "category";
    }
    @GetMapping("/category/edit")
    public String display(Model model){
        return "category";
    }
}
