package net.cuongmai.onlineshop.controller;

import net.cuongmai.onlineshop.model.Category;
import net.cuongmai.onlineshop.model.Product;
import net.cuongmai.onlineshop.service.CategoryService;
import net.cuongmai.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
//    @ResponseBody // Respond with body - the data in JSON format - only
    public String showProducts(@RequestParam (required = false) Integer categoryId,
                                  Model model) {
        List<Category> categoryList = categoryService.getActiveCategories();
        model.addAttribute("categoryList", categoryList);

        List<Product> productList = new ArrayList<>();

        if (categoryId != null) {
            productList = productService.getActiveProductsByCategory(categoryId);
            Category category = categoryService.getCategoryById(categoryId);

            model.addAttribute("category", category);
            model.addAttribute("userClickCategoryProducts", true);
        } else {
            productList = productService.getAllActiveProducts();
            model.addAttribute("userClickAllProducts", true);
        }

        model.addAttribute("productList", productList);


        return "page";
    }

//    @RequestMapping("/list/active")
//    @ResponseBody // Respond with body - the data in JSON format - only
//    public List<Product> showActiveProducts(@RequestParam (required = false) Integer categoryId) {
//
//        List<Product> productList = new ArrayList<>();
//
//        if (categoryId != null) {
//            productList = productService.getActiveProductsByCategory(categoryId);
//        } else {
//            productList = productService.getAllActiveProducts();
//        }
//
//        return productList;
//    }
}
