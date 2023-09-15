package app.controller;

import app.entity.Blog;
import app.entity.BlogCategory;
import app.service.BlogService;
import app.service.CategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private CategoryBlogService categoryBlogService;
    @Autowired
    private BlogService blogService;
    @GetMapping("/category/list")
    public ResponseEntity<List<BlogCategory>> getCategory(){
        List<BlogCategory> list = categoryBlogService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/blog/list")
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> list = blogService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> getBlog(@PathVariable Integer id){
        List<Blog> list = blogService.findByCategoryId(id);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
