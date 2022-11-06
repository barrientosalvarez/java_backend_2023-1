package com.product.api.service;

import java.util.List;
import com.product.api.entity.Category;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.product.api.repository.RepoCategory;


@Service
public class SvcCategoryImp implements SvcCategory{


    @Autowired
    RepoCategory repo;

    @Override
    public List<Category> getCategories(){
        return repo.findByStatus(1);
    }

    @Override
    public Category getCategory(Integer category_id){
        return repo.findByCategoryId(category_id);
    }

    @Override
    public String createCategory(Category c){
        Category categorySaved=(Category) repo.findByCategory(c.getCategory());

        if(categorySaved!=null){
            if(categorySaved.getStatus()==0)
                repo.activateCategory(categorySaved.getCategory_id());
            else
                return "category already exist";
        }

        repo.createCategory(c.getCategory());
        return "category created";
    }

    @Override
    public String updateCategory(Integer category_id, Category c){
        Category categorySaved=(Category) repo.findByCategoryId(category_id);

        if(categorySaved==null)
            return "category does not exist";

        else{
            if(categorySaved.getStatus()==0)
                return "category is not active";
            else{
                categorySaved=(Category) repo.findByCategory(c.getCategory());
                if(categorySaved!=null)
                    return "category already exist";

                repo.updateCategory(category_id, c.getCategory());
                return "category updated";
            }
        }
    }

    @Override
    public String deleteCategory(Integer category_id){
        Category categorySaved=(Category) repo.findByCategoryId(category_id);
        if(categorySaved==null)
            return "category does not exist";
        else{
            repo.deleteById(category_id);
            return "category removed";
        }
    }

}
