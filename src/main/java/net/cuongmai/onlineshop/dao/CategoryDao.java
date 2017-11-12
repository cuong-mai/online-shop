package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAllCategories();

    List<Category> getActiveCategories();

    Category getCategoryById(int id);

    boolean saveCategory(Category category);

    boolean deleteCategory(Category category);

    boolean deactivateCategory(Category category);

    boolean activateCategory(Category category);
}
