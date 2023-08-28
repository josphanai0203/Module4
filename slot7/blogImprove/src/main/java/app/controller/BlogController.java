package app.controller;

import app.entity.Blog;
import app.service.BlogService;
import app.service.CategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    CategoryBlogService categoryBlogService;
    @GetMapping(value = {"","/list"})
    public String displayApp(Model model,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size,
                             @RequestParam("sort") Optional<String> sortField
    ){
        Integer currentPage = page.orElse(1);
        Integer currentSize = size.orElse(3);
        String currentSortField = sortField.orElse("publishDate");
        Pageable pageable = PageRequest.of(currentPage - 1,currentSize,Sort.by(currentSortField).descending());
        Page<Blog> list = blogService.findAll(pageable);
        int totalPage = list.getTotalPages();
        if(totalPage >1){
            List<Integer> pageNumberList = IntStream.range(1,totalPage + 1 ).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumberList", pageNumberList);
        }
        model.addAttribute("category",categoryBlogService.findAll());
        model.addAttribute("list",list);
        return "index";
    }
    @GetMapping("/create")
    public String displayCreateBlogHtml(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",categoryBlogService.findAll());
        return "create";
    }
    @PostMapping("/create")
    public String doCreateNewBlog(@ModelAttribute Blog blog){
        blog.setPublishDate(new Date(System.currentTimeMillis()));
        blogService.create(blog);
        return "redirect:/list";
    }
    @GetMapping("/blog")
    public String displayBlogById(Model model,@RequestParam("id") Integer id){
        Blog blog = blogService.findById(id);
        model.addAttribute("contentList",createListContent(blog.getContent()));
        model.addAttribute("blog",blog);
        return "blog";
    }
    public List<String> createListContent(String str){
        String[] strList = str.split("\n");
        List<String> list = new ArrayList<>();
        for (String s: strList){
            list.add(s);
        }
        return list;
    }
    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam Integer id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("category",categoryBlogService.findAll());
        model.addAttribute("blog", blog);
        return "create";
    }

    @GetMapping("/delete")
    public String getDelete(Model model, @RequestParam Integer id) {
        blogService.deleteById(id);
        return "redirect:/list";
    }@GetMapping("/category")
    public String displayBlogByCategory(Model model,
                                        @RequestParam Integer id,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("size") Optional<Integer> size,
                                        @RequestParam("sort") Optional<String> sortField
    ) {
        Integer currentPage = page.orElse(1);
        Integer currentSize = size.orElse(3);
        String currentSortField = sortField.orElse("publishDate");
        Pageable pageable = PageRequest.of(currentPage - 1,currentSize,Sort.by(currentSortField).descending());
        Page<Blog> list = blogService.findAllByBlogCategoryId(pageable,id);
        int totalPage = list.getTotalPages();
        if(totalPage >1){
            List<Integer> pageNumberList = IntStream.range(1,totalPage + 1 ).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumberList", pageNumberList);
        }
        model.addAttribute("category",categoryBlogService.findAll());
        model.addAttribute("activeCategory",id);
        model.addAttribute("list",list);
        return "index";
    }

}
