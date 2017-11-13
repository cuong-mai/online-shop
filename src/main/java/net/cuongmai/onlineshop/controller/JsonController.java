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
@RequestMapping("/json")
public class JsonController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/list")
    @ResponseBody
    public List<Product> getJsonProducts(@RequestParam(required = false) Integer categoryId) {
        List<Product> productList = new ArrayList<>();

        if (categoryId != null) {
            productList = productService.getActiveProductsByCategory(categoryId);
        } else {
            productList = productService.getAllActiveProducts();
        }
        return productList;
    }
}
