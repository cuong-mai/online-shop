package net.cuongmai.onlineshop.validator;

import net.cuongmai.onlineshop.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Product product = (Product) target;

        if (!product.hasThumbnailImage() &&
                (product.getThumbnailImage() == null || product.getThumbnailImage().getOriginalFilename().equals(""))) {

            errors.rejectValue("thumbnailImage", null,
                    "Please select an image file to upload!");

            return;
        }

        if (!product.hasThumbnailImage() &&
                (! (product.getThumbnailImage().getContentType().equals("image/jpeg") ||
                product.getThumbnailImage().getContentType().equals("image/png") ||
                product.getThumbnailImage().getContentType().equals("image/gif")))) {

            errors.rejectValue("thumbnailImage", null,
                    "Please select a JPG, PNG or GIF file only!");

            return;
        }
    }
}
