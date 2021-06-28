/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Controllers;
import com.example.Entities.Tag;
import com.example.Services.TagService;
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
public class TagController {
    
    @Autowired
    private TagService service;
    
    @RequestMapping("tag-all")
    public List<Tag> getAll(){
        return service.getAllTags();
    }
    
    @RequestMapping("tag-{id}")
    public Optional<Tag> getTag(@PathVariable String id){
        return service.getTag(Long.parseLong(id));
    }
    
    @RequestMapping("tag-title/{title}")
    public Optional<Tag> getTagTitle(@PathVariable String title){
        return service.getTagTitle(title);
    }
    
    @RequestMapping("tag-titlepart/{title}")
    public List<Tag> getTagTitlepart(@PathVariable String title){
        return service.getTagTitlepart(title);
    }
    
    @RequestMapping("tag-titlepart/{title}/category/{id}")
    public List<Tag> getTagTitlepartCategory(@PathVariable String title, @PathVariable Long id){
        return service.getTagTitlepartCategory(title, id);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/tag")
    public void addTag(@RequestBody Tag tag){
        service.addTag(tag);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/tag")
    public void updateTag(@RequestBody Tag tag){
        service.updateTag(tag);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/tag-id/{id}")
    public void deleteTag(@PathVariable String id){
        service.deleteTag(Long.parseLong(id));
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/tag-event/{idT}/{idE}")
    public void addEvent(@PathVariable String idT, @PathVariable String idE){
        service.addEvent(Long.parseLong(idT), Long.parseLong(idE));
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/tag-event/{idT}/{idE}")
    public void removeEvent(@PathVariable String idT, @PathVariable String idE){
        service.removeEvent(Long.parseLong(idT), Long.parseLong(idE));
    }
}
