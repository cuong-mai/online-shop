package net.cuongmai.onlineshop.controller;

import net.cuongmai.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String showProducts(@RequestParam int categoryId) {
        System.out.println(productService.getAllProductsByCategory(categoryId));
        return "";
    }
}
