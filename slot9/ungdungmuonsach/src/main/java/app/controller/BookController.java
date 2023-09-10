package app.controller;

import app.service.BookService;
import app.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderBookService orderBookService;
    @GetMapping(value = {"","/list"})
    public String getIndexView(Model model,RedirectAttributes redirectAttributes){
        model.addAttribute("list",bookService.findAll());
        model.addAttribute("check", redirectAttributes.getFlashAttributes())
       ;
        return "index";
    }
    @GetMapping("/rent/create")
    public String getRentView(Model model, @RequestParam("id")long id){
        model.addAttribute("book",bookService.findById(id));
        return "rent";
    }
    @PostMapping("/rent/create")
    public String doRentBook(@RequestParam("id")long id,Model model){
        long key =  bookService.rentBook(id);
        model.addAttribute("key",key);
        model.addAttribute("book",bookService.findById(id));
        return "rent";
    }
    @PostMapping("/book/return")
    public String doReturnBook(@RequestParam("key")long id, RedirectAttributes redirectAttributes){
        boolean check = bookService.returnBook(id);
        redirectAttributes.addFlashAttribute("check",check);
        return "redirect:/list";
    }
}
