package app.controller;

import app.model.Product;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("")
    public String getDefault(Model model){
        model.addAttribute("list",productService.findAll());
        DecimalFormat currencyFormat = new DecimalFormat("###,### VNĐ");
        model.addAttribute("currencyFormat", currencyFormat);
        return "index";
    }@GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("list",productService.findAll());
        DecimalFormat currencyFormat = new DecimalFormat("###,### VNĐ");
        model.addAttribute("currencyFormat", currencyFormat);
        return "index";
    }
    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("product",new Product());
        return "product/create";
    } @PostMapping ("/create")
    public String postCreate(Model model, @ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/home";
    }
    @GetMapping("/product/delete")
    public String doDelete(Model model, @RequestParam("id")int id){
        productService.remove(id);
        return "redirect:/home";
    }@GetMapping("/product/detail")
    public String doDetail(Model model, @RequestParam("id")int id){
        model.addAttribute("product",productService.findById(id));
        return "product/detail";
    }
}
