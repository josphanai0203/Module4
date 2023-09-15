package app.controller;

import app.dto.CardDto;
import app.dto.ProductDto;
import app.entity.Product;
import app.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CardDto initCart(){
        return new CardDto();
    }
    @Autowired
    ProductService productService;
    @GetMapping
    public ModelAndView showListPage(Model model,
                                     @CookieValue(value = "idProduct",
                                     defaultValue = "-1") Long idProduct){
        if(idProduct != -1){
            model.addAttribute("historyProduct",productService.findById(idProduct));
        }
        return new ModelAndView("product_list","productList",productService.findAll());
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct",id+"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("detail","product",productService.findById(id));
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CardDto cardDto){
        Product product = productService.findById(id);
        if(product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cardDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }

}
