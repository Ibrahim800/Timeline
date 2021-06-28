/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Controllers;
import com.example.Entities.Event;
import com.example.Entities.Tag;
import com.example.Services.EventService;
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
public class EventController {
    
    @Autowired
    private EventService service;
    
    @RequestMapping("/event-all")
    public List<Event> getAll(){
        return service.getAllEvents();
    }
    
    @RequestMapping("/event-id/{id}")
    public Optional<Event> getEvent(@PathVariable String id){
        return service.getEvent(Long.parseLong(id));
    }
    
    @RequestMapping("/event-title/{title}")
    public Optional<Event> getEventTitle(@PathVariable String title){
        return service.getEventTitle(title);
    }
    
    @RequestMapping("/event-titlepart/{title}")
    public List<Event> getEventTitlepart(@PathVariable String title){
        return service.getEventTitlepart(title);
    }
    
    @RequestMapping("/event-tag/{id}")
    public List<Event> getEventTag(@PathVariable Long id){
        return service.getEventTag(id);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/event-tags/I")
    public List<Event> getEventTags_I(@RequestBody List<Long> ids){
        return service.getEventTags_I(ids);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/event-tags/U")
    public List<Event> getEventTags_U(@RequestBody List<Long> ids){
        return service.getEventTags_U(ids);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/event")
    public void addEvent(@RequestBody Event event){
        service.addEvent(event);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/event")
    public void updateEvent(@RequestBody Event event){
        service.updateEvent(event);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/event-id/{id}")
    public void deleteEvent(@PathVariable String id){
        service.deleteEvent(Long.parseLong(id));
    }
       
}
