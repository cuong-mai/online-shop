package net.cuongmai.onlineshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "net.cuongmai.onlineshop.model")
@EnableTransactionManagement
public class HibernateConfig {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String DATABASE_USERNAME = "hbstudent";
    private static final String DATABASE_PASSWORD = "hbstudent";


}
