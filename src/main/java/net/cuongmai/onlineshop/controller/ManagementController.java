package net.cuongmai.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManagementController {

    @GetMapping("/product/list")
    public String showManageProducts(Model model) {


        model.addAttribute("userClickManageProducts", true);
        model.addAttribute("title", "Manage Products");

        return "page";
    }
}
