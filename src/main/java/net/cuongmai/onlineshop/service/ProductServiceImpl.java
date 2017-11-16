package net.cuongmai.onlineshop.service;

import net.cuongmai.onlineshop.dao.ProductDao;
import net.cuongmai.onlineshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    @Transactional
    public List<Product> getAllProductsByCategory(int categoryId) {
        return productDao.getAllProductsByCategory(categoryId);
    }

    @Override
    @Transactional
    public List<Product> getAllActiveProducts() {
        return productDao.getAllActiveProducts();
    }

    @Override
    @Transactional
    public List<Product> getActiveProductsByCategory(int categoryId) {
        return productDao.getActiveProductsByCategory(categoryId);
    }

    @Override
    @Transactional
    public List<Product> getLatestActiveProducts(int count) {
        return productDao.getLatestActiveProducts(count);
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    @Transactional
    public boolean saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    @Override
    @Transactional
    public boolean toggleProductActivation(Product product) {
        return productDao.toggleProductActivation(product);
    }

    @Override
    @Transactional
    public boolean activateProduct(Product product) {
        return productDao.activateProduct(product);
    }

    @Override
    @Transactional
    public boolean deactivateProduct(Product product) {
        return productDao.deactivateProduct(product);
    }

    @Override
    @Transactional
    public boolean deleteProduct(Product product) {
        return productDao.deleteProduct(product);
    }
}
