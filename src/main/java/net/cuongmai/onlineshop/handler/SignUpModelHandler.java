package net.cuongmai.onlineshop.handler;

import net.cuongmai.onlineshop.dao.AddressDao;
import net.cuongmai.onlineshop.dao.UserDao;
import net.cuongmai.onlineshop.model.Address;
import net.cuongmai.onlineshop.model.SignUpModel;
import net.cuongmai.onlineshop.model.User;
import net.cuongmai.onlineshop.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpModelHandler {

    @Autowired
    private SignUpService signUpService;

    public SignUpModel init() {
        return new SignUpModel();
    }

    public void addUser(SignUpModel signUpModel, User user) {
        signUpModel.setUser(user);
    }

    public void addBillingAddress(SignUpModel signUpModel, Address billingAddress) {
        signUpModel.setBillingAddress(billingAddress);
    }

    public String saveAll(SignUpModel signUpModel) {
        String transitionResult = "success";

        User user = signUpModel.getUser();
        Address billingAddress = signUpModel.getBillingAddress();
        billingAddress.setUser(user);

        signUpService.saveUser(user);
        signUpService.saveAddress(billingAddress);

        return transitionResult;
    }
}
