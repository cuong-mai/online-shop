package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<Product> query = session.createQuery("from Product", Product.class);
            List<Product> productList = query.getResultList();
            return productList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getAllProductsByCategory(int categoryId) {
            Session session = sessionFactory.getCurrentSession();

            try {
                Query<Product> query = session.createQuery("from Product where categoryId = :categoryId", Product.class);
                query.setParameter("categoryId", categoryId);

                List<Product> productList = query.getResultList();
                return productList;

            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
    }

    @Override
    public List<Product> getAllActiveProducts() {
        Session session = sessionFactory.getCurrentSession();

        try {
            Query<Product> query = session.createQuery("from Product where active = :active", Product.class);
            query.setParameter("active", true);

            List<Product> productList = query.getResultList();
            return productList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getActiveProductsByCategory(int categoryId) {
        Session session = sessionFactory.getCurrentSession();

        try {
            Query<Product> query =
                    session.createQuery("from Product where active = :active and categoryId = :categoryId",
                            Product.class);
            query.setParameter("active", true)
                    .setParameter("categoryId", categoryId);

            List<Product> productList = query.getResultList();
            return productList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        Session session = sessionFactory.getCurrentSession();

        try {
            Query<Product> query =
                    session.createQuery("from Product where active = :active order by id desc", Product.class);

            query.setParameter("active", true);
            query.setFirstResult(0)
                    .setMaxResults(count);

            List<Product> productList = query.getResultList();
            return productList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();

        try {
            Product product = session.get(Product.class, id);
            return product;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.saveOrUpdate(product);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean activateProduct(Product product) {
        try {
            product.setActive(true);
            saveProduct(product);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deactivateProduct(Product product) {
        try {
            product.setActive(false);
            saveProduct(product);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.delete(product);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
