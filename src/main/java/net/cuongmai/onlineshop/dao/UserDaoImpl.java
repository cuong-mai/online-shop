package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Address;
import net.cuongmai.onlineshop.model.Cart;
import net.cuongmai.onlineshop.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserById(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.get(User.class, id);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            Session session = sessionFactory.getCurrentSession();

            Query<User> query = session.createQuery("from User where email = :email", User.class);
            query.setParameter("email", email);

            User user = query.getSingleResult();

            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveUser(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
