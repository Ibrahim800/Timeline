
package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Entities.Event;
import com.example.Entities.Tag;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface EventRepository extends JpaRepository<Event, Long>{
    Optional<Event> findByEventTitle(String title);
//    Optional<Event> findByTags_tagIdIn(Long id);
    List<Event> findByTags_tagIdIn(Long id);
    List<Event> findByEventTitleStartingWith(String title);
}
