package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Address;
import net.cuongmai.onlineshop.model.User;

import java.util.List;

public interface AddressDao {
    Address getBillingAddressByUser(User user);
    List<Address> getShippingAddressListByUser(User user);
    boolean saveAddress(Address address);
}
