/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Services;

import com.example.Entities.Event;
import com.example.Entities.Tag;
import com.example.Repository.EventRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
       
    @Autowired
    EventRepository repository;
        
    public List<Event> getAllEvents(){
        return repository.findAll();
    }
    
    public Optional<Event> getEvent(Long id){
        return repository.findById(id);
    }
    
    public Optional<Event> getEventTitle(String title){
        return repository.findByEventTitle(title);
    }
    
    public List<Event> getEventTitlepart(String title){
        return repository.findByEventTitleStartingWith(title);
    }
    
    public List<Event> getEventTag(Long id){
        return repository.findByTags_tagIdIn(id);
    }
    
    public List<Event> getEventTags_I(List<Long> ids){
        List<Event> ret = null;
        List<Event> tmp = null;
        for(int i = 0; i < ids.size() ; i++){
            if (i == 0){
                ret = repository.findByTags_tagIdIn(ids.get(i));
            }else{
                tmp = repository.findByTags_tagIdIn(ids.get(i));
                ret = ret.stream().distinct().filter(tmp::contains).collect(Collectors.toList());
            }
        }
        return ret;
    }
    
    public List<Event> getEventTags_U(List<Long> ids){
        List<Event> ret = null;
        List<Event> tmp = null;
        Set<Event> set = new HashSet<Event>();
        for(int i = 0; i < ids.size() ; i++){
            ret = repository.findByTags_tagIdIn(ids.get(i));
            set.addAll(ret);
        }
        ret = new ArrayList<Event>(set);
        return ret;
    }
    
    public void addEvent(Event event){
        repository.save(event);
    }
    
    public void updateEvent(Event event){
        Long id = event.getEventId();
        if(repository.findById(id).isPresent()){
            repository.save(event);
        }
    }
    
    public void deleteEvent(Long id){
        repository.deleteById(id);
    }
    
}
