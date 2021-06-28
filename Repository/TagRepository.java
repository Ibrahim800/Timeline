
package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Entities.Tag;
import java.util.List;
import java.util.Optional;


public interface TagRepository extends JpaRepository<Tag, Long>{
    Optional<Tag> findByTagTitle(String title);
    List<Tag> findByTagTitleStartingWithAndCategoryId_categoryIdIn(String title, Long id);
    List<Tag> findByTagTitleStartingWith(String title);
}
