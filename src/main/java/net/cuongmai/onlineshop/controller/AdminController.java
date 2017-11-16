package net.cuongmai.onlineshop.controller;

import net.cuongmai.onlineshop.model.Category;
import net.cuongmai.onlineshop.model.Product;
import net.cuongmai.onlineshop.service.CategoryService;
import net.cuongmai.onlineshop.service.ProductService;
import net.cuongmai.onlineshop.util.FileUploadUtility;
import net.cuongmai.onlineshop.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryList")
    public List<Category> getCategoryList() {
        return categoryService.getAllCategories();
    }

    @RequestMapping({"", "/"})
    public String showAdminPortal(Model model) {

        model.addAttribute("userClickAdmin", true);
        model.addAttribute("title", "Admin Portal");

        return "page";
    }

    @RequestMapping("/product/list")
    public String showProductList(Model model) {

        model.addAttribute("userClickAdminProduct", true);
        model.addAttribute("title", "Manage Products");

        return "page";
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

    @PostMapping("/product/toggleActivation")
    @ResponseBody
    public boolean toggleProductActivation(@RequestParam Integer id) {

        Product product = productService.getProductById(id);

        return productService.toggleProductActivation(product);
    }

    @PostMapping("/product/save")
    public String saveProduct(HttpServletRequest request,
                              @Valid @ModelAttribute Product product,
                              BindingResult result,
                              Model model) {

        ProductValidator productValidator = new ProductValidator();
        productValidator.validate(product, result);

        if (result.hasErrors()) {
            model.addAttribute("userClickEditProduct", true);
            model.addAttribute("title", "Edit Product");

            return "page";
        }

        productService.saveProduct(product);

        if (!product.getThumbnailImage().getOriginalFilename().equals("")) {
            FileUploadUtility.uploadFile(request,
                    product.getThumbnailImage(),
                    Integer.toString(product.getId()),
                    "thumbnail");
        }

        return "redirect:/admin/product/list";
    }
}
