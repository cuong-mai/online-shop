package net.cuongmai.onlineshop.controller;

import net.cuongmai.onlineshop.exception.ProductNotFoundException;
import net.cuongmai.onlineshop.model.Category;
import net.cuongmai.onlineshop.model.Product;
import net.cuongmai.onlineshop.service.CategoryService;
import net.cuongmai.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
        model.addAttribute("title", "Products");

        return "page";
    }

    @RequestMapping("/detail")
    public String showProductDetail(@RequestParam Integer id,
                                    HttpServletRequest request,
                                    Model model)
            throws ProductNotFoundException {

        Product product = productService.getProductById(id);

        if (product == null) {
            throw new ProductNotFoundException();
        }

        product.setViews(product.getViews() + 1);

        String previousPageUrl = request.getHeader("referer");

        model.addAttribute("product", product);
        model.addAttribute("userClickProductDetail", true);
        model.addAttribute("title", product.getName());
        model.addAttribute("previousPageUrl", previousPageUrl);

        return "page";
    }
}
