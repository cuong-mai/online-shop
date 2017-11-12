package net.cuongmai.onlineshop.controller;

import net.cuongmai.onlineshop.model.Category;
import net.cuongmai.onlineshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping({"/", "/home", "/index"})
    public String showHome(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("userClickHome", true);

        List<Category> categoryList = categoryService.getCategoryList();

        model.addAttribute("categoryList", categoryList);

        System.out.println(categoryList);

        return "page";
    }

    @RequestMapping("/about")
    public String showAbout(Model model) {
        model.addAttribute("title", "About");
        model.addAttribute("userClickAbout", true);
        return "page";
    }

    @RequestMapping("/contact")
    public String showContact(Model model) {
        model.addAttribute("title", "Contact");
        model.addAttribute("userClickContact", true);
        return "page";
    }
}
