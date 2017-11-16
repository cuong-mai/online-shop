package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();

    List<Product> getAllProductsByCategory(int categoryId);

    List<Product> getAllActiveProducts();

    List<Product> getActiveProductsByCategory(int categoryId);

    List<Product> getLatestActiveProducts(int count);

    Product getProductById(int id);

    boolean saveProduct(Product product);

    boolean toggleProductActivation(Product product);

    boolean activateProduct(Product product);

    boolean deactivateProduct(Product product);

    boolean deleteProduct(Product product);

}
