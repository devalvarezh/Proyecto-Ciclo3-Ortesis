package com.AlquilerOrtesis.Ortesis3.Services;

import com.AlquilerOrtesis.Ortesis3.Model.Category;
import com.AlquilerOrtesis.Ortesis3.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category createCategory(Category category){
        if(category.getId() ==null){
            return categoryRepository.save(category);
        } else {
            return category;
        }
    }

    public Category updateCategory(Category category){
        if(category.getId()!=null){
            Optional<Category> temp =categoryRepository.getCategory(category.getId());
            if(temp.isPresent()){
                if(category.getName()!=null)
                    temp.get().setName(category.getName());
                if(category.getDescription()!=null)
                    temp.get().setDescription(category.getDescription());
                return categoryRepository.save(temp.get());
            }else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean deleteCategory(int id){
        Boolean success = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return true;
    }

}
