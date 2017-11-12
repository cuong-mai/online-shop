package net.cuongmai.onlineshop.service;

import net.cuongmai.onlineshop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getAllProductsByCategory(int categoryId);

    List<Product> getActiveProducts();

    List<Product> getActiveProductsByCategory(int categoryId);

    List<Product> getLatestActiveProducts(int count);

    Product getProductById(int id);

    boolean saveProduct(Product product);

    boolean activateProduct(Product product);

    boolean deactivateProduct(Product product);

    boolean deleteProduct(Product product);
}
