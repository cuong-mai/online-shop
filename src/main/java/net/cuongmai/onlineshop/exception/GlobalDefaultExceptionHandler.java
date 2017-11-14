package net.cuongmai.onlineshop.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handlerNoHandlerFoundException(Model model) {

        model.addAttribute("errorTitle", "404 - Page Not Found");
        model.addAttribute("errorDescription", "The page you are requesting doesn't exist!");
        model.addAttribute("title", "404 (Page Not Found)");

        return "error";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handlerProductNotFoundException(Model model) {

        model.addAttribute("errorTitle", "Product Not Available");
        model.addAttribute("errorDescription",
                "The product you are looking for is not available!");
        model.addAttribute("title", "Product Not Available");

        return "error";
    }
}
