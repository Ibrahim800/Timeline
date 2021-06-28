/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Services;
import com.example.Entities.Event;
import com.example.Entities.Tag;
import com.example.Repository.EventRepository;
import com.example.Repository.TagRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TagService {
    
    @Autowired
    private TagRepository repository;
    
    @Autowired
    private EventRepository eventRepository;
    
    public List<Tag> getAllTags(){
        return repository.findAll();
    }
    
    public Optional<Tag> getTag(Long id){
        return repository.findById(id);
    }
    
    public Optional<Tag> getTagTitle(String title){
        return repository.findByTagTitle(title);
    }
    
    public List<Tag> getTagTitlepart(String title){
        return repository.findByTagTitleStartingWith(title);
    }
    
    public List<Tag> getTagTitlepartCategory(String title, Long id){
        return repository.findByTagTitleStartingWithAndCategoryId_categoryIdIn(title, id);
    }
    
    public void addTag(Tag tag){
        repository.save(tag);
    }
    
    public void updateTag(Tag tag){
        Long id = tag.getTagId();
        if(repository.findById(id).isPresent()){
            repository.save(tag);
        }
    }
    
    public void deleteTag(Long id){
        repository.deleteById(id);
    }
    
    public void addEvent(Long idTag, Long idEvent){
        Optional<Event> OEvent = eventRepository.findById(idEvent);
        Optional<Tag> OTag = repository.findById(idTag);
        if(!OEvent.isPresent() || !OTag.isPresent()){
            return;
        }
        Event event = OEvent.get();
        Tag tag = OTag.get();
        event.addTag(tag);
        tag.addEvent(event);
        repository.save(tag);
        eventRepository.save(event);
    }
    
    public void removeEvent(Long idTag, Long idEvent){
        Optional<Event> OEvent = eventRepository.findById(idEvent);
        Optional<Tag> OTag = repository.findById(idTag);
        if(!OEvent.isPresent() || !OTag.isPresent()){
            return;
        }
        Event event = OEvent.get();
        Tag tag = OTag.get();
        event.removeTag(tag.getTagId());
        tag.removeEvent(event.getEventId());
        eventRepository.save(event);
        repository.save(tag);
    }

    public List<Tag> getTagTitlepart(String title, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
