/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Controllers;
import com.example.Entities.Category;
import com.example.Services.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin
public class CategoryController {
    
    @Autowired
    private CategoryService service;
    
    
    @RequestMapping("/")
    public String hello(){
        return "HIIIII";
    }
        
    @RequestMapping("/category-all")
    public List<Category> getAll(){
        return service.getAllCategory();
    }
    
    @RequestMapping("/category-id/{id}")
    public Optional<Category> getCategory(@PathVariable String id){
        return service.getCategory(Long.parseLong(id));
    }
    
    @RequestMapping("/category-title/{title}")
    public Optional<Category> getCategoryTitle(@PathVariable String title){
        return service.getCategoryTitle(title);
    }
    
    @RequestMapping("/category-titlepart/{title}")
    public List<Category> getCategoryTitlePart(@PathVariable String title){
        return service.getCategoryTitlePart(title);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/category")
    public void addCategory(@RequestBody Category category){
        service.addCategory(category);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/category")
    public void updateCategory(@RequestBody Category category){
        service.updateCategory(category);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/category-id/{id}")
    public void deleteCategory(@PathVariable String id){
        service.deleteCategory(Long.parseLong(id));
    }
    
}
