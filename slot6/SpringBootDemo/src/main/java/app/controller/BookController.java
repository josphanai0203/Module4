package app.controller;

import app.entity.Book;
import app.service.BookService;
import app.service.CategoryService;
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping(value = {"","/list"})
    public String displayListBook(Model model,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int sizePage = size.orElse(5);
        Pageable pageable =  PageRequest.of(currentPage - 1,sizePage,Sort.by("name").ascending());
        Page<Book> books = bookService.findAll(pageable);
        model.addAttribute("list",books);
        int totalPages = books.getTotalPages();
        if(totalPages > 1){
            List<Integer> pageNumber = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumber);
        }
        return "index";
    }
    @GetMapping("/create")
    public String displayCreateForm(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("book", new Book());
        return "create";
    }
    @PostMapping ("/create")
    public String doCreateForm(@ModelAttribute Book book){
        bookService.create(book);
        return "redirect:/list";
    }

}
