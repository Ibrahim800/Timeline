/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Services;

import com.example.Entities.Category;
import com.example.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository repository;
        
    public List<Category> getAllCategory(){
        return repository.findAll();
    }
    
    public Optional<Category> getCategory(Long id){
        return repository.findById(id);
    }
    
    public Optional<Category> getCategoryTitle(String title){
        return repository.findByCategoryTitle(title);
    }
    
    public List<Category> getCategoryTitlePart(String title){
        return repository.findByCategoryTitleStartingWith(title);
    }
    
    public void addCategory(Category category){
        repository.save(category);
    }
    
    public void updateCategory(Category category){
        Long id = category.getCategoryId();
        if(repository.findById(id).isPresent()){
            repository.save(category);
        }
    }
    
    public void deleteCategory(Long id){
        repository.deleteById(id);
    }
    
}
