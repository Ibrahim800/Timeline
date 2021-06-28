package com.example.Repository;

import com.example.Entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long>{
    Optional<Category> findByCategoryTitle(String title);
    List<Category> findByCategoryTitleStartingWith(String title);
}
