package net.cuongmai.onlineshop.service;

import net.cuongmai.onlineshop.dao.CategoryDao;
import net.cuongmai.onlineshop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    @Transactional
    public List<Category> getActiveCategories() {
        return categoryDao.getActiveCategories();
    }

    @Override
    @Transactional
    public Category getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    @Transactional
    public boolean saveCategory(Category category) {
        return categoryDao.saveCategory(category);
    }

    @Override
    @Transactional
    public boolean deleteCategory(Category category) {
        return categoryDao.deleteCategory(category);
    }

    @Override
    @Transactional
    public boolean deactivateCategory(Category category) {
        return categoryDao.deactivateCategory(category);
    }

    @Override
    public boolean activateCategory(Category category) {
        return categoryDao.activateCategory(category);
    }
}
