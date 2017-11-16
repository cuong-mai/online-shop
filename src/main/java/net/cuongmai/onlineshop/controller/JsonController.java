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
public class JsonController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/json/product/list/active")
    @ResponseBody
    public List<Product> getJsonActiveProducts(@RequestParam(required = false) Integer categoryId) {
        List<Product> productList = new ArrayList<>();

        if (categoryId != null) {
            productList = productService.getActiveProductsByCategory(categoryId);
        } else {
            productList = productService.getAllActiveProducts();
        }
        return productList;
    }

    @RequestMapping("/admin/json/product/list/all")
    @ResponseBody
    public List<Product> getJsonAllProducts(@RequestParam(required = false) Integer categoryId) {
        List<Product> productList = new ArrayList<>();

        if (categoryId != null) {
            productList = productService.getAllProductsByCategory(categoryId);
        } else {
            productList = productService.getAllProducts();
        }
        return productList;
    }
}
