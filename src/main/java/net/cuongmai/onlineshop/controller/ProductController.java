package net.cuongmai.onlineshop.controller;

import net.cuongmai.onlineshop.model.Product;
import net.cuongmai.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list/all")
    @ResponseBody // Respond with body - the data in JSON format - only
    public List<Product> showAllProducts(@RequestParam (required = false) Integer categoryId) {

        List<Product> productList = new ArrayList<>();

        if (categoryId != null) {
            productList = productService.getAllProductsByCategory(categoryId);
        } else {
            productList = productService.getAllProducts();
        }

        return productList;
    }

    @RequestMapping("/list/active")
    @ResponseBody // Respond with body - the data in JSON format - only
    public List<Product> showActiveProducts(@RequestParam (required = false) Integer categoryId) {

        List<Product> productList = new ArrayList<>();

        if (categoryId != null) {
            productList = productService.getActiveProductsByCategory(categoryId);
        } else {
            productList = productService.getAllActiveProducts();
        }

        return productList;
    }
}
