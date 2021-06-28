/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
   
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    
    @Column(name = "Category_title")
    private String categoryTitle;
    
    @Column(name = "category_decription")
    private String categoryDescription; 
    
    @Column(name = "category_color_r")
    private int categoryColorR;
    
    @Column(name = "category_color_g")
    private int categoryColorG;
    
    @Column(name = "category_color_b")
    private int categoryColorB;
    
    @OneToMany(mappedBy = "categoryId")
    @JsonIgnore
    private List<Tag> tagy;

    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String category_title) {
        this.categoryTitle = category_title;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public int getCategoryColorR() {
        return categoryColorR;
    }

    public void setCategoryColorR(int categoryColorR) {
        this.categoryColorR = categoryColorR;
    }

    public int getCategoryColorG() {
        return categoryColorG;
    }

    public void setCategoryColorG(int categoryColorG) {
        this.categoryColorG = categoryColorG;
    }

    public int getCategoryColorB() {
        return categoryColorB;
    }

    public void setCategoryColorB(int categoryColorB) {
        this.categoryColorB = categoryColorB;
    }

    

    public List<Tag> getTagy() {
        return tagy;
    }

    public void setTagy(List<Tag> tagy) {
        this.tagy = tagy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (this.categoryColorR != other.categoryColorR) {
            return false;
        }
        if (this.categoryColorG != other.categoryColorG) {
            return false;
        }
        if (this.categoryColorB != other.categoryColorB) {
            return false;
        }
        if (!Objects.equals(this.categoryTitle, other.categoryTitle)) {
            return false;
        }
        if (!Objects.equals(this.categoryDescription, other.categoryDescription)) {
            return false;
        }
        if (!Objects.equals(this.categoryId, other.categoryId)) {
            return false;
        }
        if (!Objects.equals(this.tagy, other.tagy)) {
            return false;
        }
        return true;
    }
    
}
