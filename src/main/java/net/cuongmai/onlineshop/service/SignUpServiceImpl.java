package net.cuongmai.onlineshop.service;

import net.cuongmai.onlineshop.dao.AddressDao;
import net.cuongmai.onlineshop.dao.UserDao;
import net.cuongmai.onlineshop.model.Address;
import net.cuongmai.onlineshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    @Transactional
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    @Transactional
    public boolean saveAddress(Address address) {
        return addressDao.saveAddress(address);
    }
}
