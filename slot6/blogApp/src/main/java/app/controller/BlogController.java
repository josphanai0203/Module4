package app.controller;

import app.entity.Blog;
import app.repository.BlogRepository;
import app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;


    @GetMapping(value = {"", "/list"})
    public String getDefault(Model model) {
        model.addAttribute("list", blogService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String getCreate(@ModelAttribute Blog blog) {
        blog.setPublishDate(new Date(System.currentTimeMillis()));
        System.out.println(blog.getId());
        blogService.create(blog);
        return "redirect:/list";
    }

    @GetMapping("/blog")
    public String getBlog(Model model, @RequestParam long id) {
        Blog blog = blogService.findById(id);
        ArrayList<String> list = new ArrayList<>();
        String[] strings = blog.getContent().split("\n");
        for (String p : strings) {
            list.add(p);
        }
        model.addAttribute("blog", blog);
        model.addAttribute("list", list);
        return "blog";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam long id) {
        Blog blog = blogService.findById(id);

        model.addAttribute("blog", blog);
        model.addAttribute("action", "update");
        return "create";
    }

    @GetMapping("/delete")
    public String getDelete(Model model, @RequestParam long id) {
        blogService.delete(id);
        return "redirect:/list";
    }
}
