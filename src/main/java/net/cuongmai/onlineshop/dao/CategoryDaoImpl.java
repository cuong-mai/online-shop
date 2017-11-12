package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getAllCategories() {
        try {
            Session session = sessionFactory.getCurrentSession();

            Query<Category> query = session.createQuery("from Category", Category.class);
            List<Category> categoryList = query.getResultList();

            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> getActiveCategories() {
        try {
            Session session = sessionFactory.getCurrentSession();

            Query<Category> query = session.createQuery("from Category where active = true", Category.class);
            List<Category> categoryList = query.getResultList();

            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Category getCategoryById(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Category category = session.get(Category.class, id);
            return category;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.saveOrUpdate(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.delete(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deactivateCategory(Category category) {
        try {
            category.setActive(false);
            saveCategory(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean activateCategory(Category category) {
        try {
            category.setActive(true);
            saveCategory(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
