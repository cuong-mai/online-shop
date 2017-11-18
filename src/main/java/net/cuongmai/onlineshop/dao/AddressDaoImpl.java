package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Address;
import net.cuongmai.onlineshop.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Address getBillingAddressByUser(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();

            Query<Address> query = session.createQuery(
                    "from Address where user = :user and billing = :billing",
                    Address.class);
            query.setParameter("user", user);
            query.setParameter("billing", true);

            Address address = query.getSingleResult();

            return address;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Address> getShippingAddressListByUser(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();

            Query<Address> query = session.createQuery(
                    "from Address where user = :user and shipping = :shipping",
                    Address.class);
            query.setParameter("user", user);
            query.setParameter("shipping", true);

            List<Address> addressList = query.getResultList();

            return addressList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveAddress(Address address) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(address);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
