package net.cuongmai.onlineshop.service;

import net.cuongmai.onlineshop.dao.CategoryDao;
import net.cuongmai.onlineshop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }
}
