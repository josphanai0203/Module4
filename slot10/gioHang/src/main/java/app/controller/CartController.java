package app.controller;

import app.dto.CardDto;
import app.dto.ProductDto;
import app.entity.Product;
import app.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart",required = false)CardDto cardDto){
        return new ModelAndView("cart/list","cart",cardDto);
    }
    @GetMapping("/add/{id}")
    public String addValue( @SessionAttribute(value = "cart",required = false)CardDto cardDto, @PathVariable Long id){
        Product p = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(p,productDto);
        cardDto.addProduct(productDto);
        return "redirect:/cart";
    }
    @GetMapping("/sub/{id}")
    public String subValue(@SessionAttribute(value = "cart",required = false)CardDto cardDto, @PathVariable Long id){
        Product p = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(p,productDto);
        cardDto.minusProduct(productDto);

        return "redirect:/cart";
    }
}
