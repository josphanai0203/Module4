package app.controller;

import app.entity.Blog;
import app.entity.BlogCategory;
import app.service.BlogService;
import app.service.CategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
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
    public ResponseEntity<Page<Blog>> getAllBlog(@RequestParam("page") Optional<Integer> page,
                                                 @RequestParam("size") Optional<Integer> size,
                                                 @RequestParam("sort") Optional<String> sortField){
        Integer currentPage = page.orElse(1);
        Integer currentSize = size.orElse(3);
        String currentSortField = sortField.orElse("publishDate");
        Pageable pageable = PageRequest.of(currentPage - 1,currentSize, Sort.by(currentSortField).descending());
        Page<Blog> list = blogService.findAll(pageable);
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
    @GetMapping("/blog/search")
    public ResponseEntity<List<Blog>> searchByTitle(@RequestParam("name") String value){
        return new ResponseEntity<>(blogService.searchByTitle(value),HttpStatus.OK);
    }
}
