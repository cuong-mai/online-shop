package net.cuongmai.onlineshop.dao;

import net.cuongmai.onlineshop.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public List<Category> getCategoryList() {

        List<Category> categoryList = new ArrayList<>();

        Category category1 = new Category("Instrument", "", "", true);
        category1.setId(1);

        Category category2 = new Category("Computer", "", "", true);
        category1.setId(2);

        Category category3 = new Category("Clothing", "", "", true);
        category1.setId(3);

        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);

        return categoryList;
    }
}
