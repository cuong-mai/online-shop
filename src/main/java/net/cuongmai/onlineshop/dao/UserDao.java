package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Address;
import net.cuongmai.onlineshop.model.Cart;
import net.cuongmai.onlineshop.model.User;

public interface UserDao {
    User getUserById(int id);
    User getUserByEmail(String email);
    boolean saveUser(User user);
}
