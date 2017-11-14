package net.cuongmai.onlineshop.controller;

import net.cuongmai.onlineshop.model.Category;
import net.cuongmai.onlineshop.model.Product;
import net.cuongmai.onlineshop.service.CategoryService;
import net.cuongmai.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagementController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryList")
    public List<Category> getCategoryList() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/product/edit")
    public String showEditProduct(@RequestParam (required = false) Integer id,
                                  Model model) {

        Product product = new Product();
        // TODO: Remove this setSupplierId
        product.setSupplierId(4);

        if (id != null) {
            product = productService.getProductById(id);
        }

        model.addAttribute("product", product);

        model.addAttribute("userClickEditProduct", true);
        model.addAttribute("title", "Edit Product");

        return "page";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product) {

        productService.saveProduct(product);

        return "redirect:/product/list";
    }
}
