package net.cuongmai.onlineshop.service;

import net.cuongmai.onlineshop.model.Address;
import net.cuongmai.onlineshop.model.User;
import org.springframework.stereotype.Service;

public interface SignUpService {
    boolean saveUser(User user);
    boolean saveAddress(Address address);
}
