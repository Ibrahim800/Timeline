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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tags")
public class Tag {
    
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    
    @Column(name = "tag_title")
    private String tagTitle;
    
    @Column(name = "tag_description")
    private String tagDescription;
    
    @JoinColumn(name = "category_id")
    @ManyToOne(optional = true)
    private Category categoryId;
    
    @ManyToMany
    @JoinTable(name = "tag_event_relations",  
               joinColumns = @JoinColumn(name = "tag_id"), 
               inverseJoinColumns = @JoinColumn(name = "event_id"))
    @JsonIgnore
    private List<Event> events;

    public Tag() {
        this.events = null;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
    
    
    
    public List<Event> getEvents() {
        return events;
    } 
    
    public void addEvent(Event event){
        for(int i = 0; i < events.size() ; i++){
            if(events.get(i).getEventId().equals(event.getEventId())){
                return;
            }
        }
        this.events.add(event);
    }
    
    public void removeEvent(Long id){
        for(int i = 0; i < events.size() ; i++){
            if(events.get(i).getEventId().equals(id)){
                events.remove(i);
                break;
            }
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Tag other = (Tag) obj;
        if (!Objects.equals(this.tagTitle, other.tagTitle)) {
            return false;
        }
        if (!Objects.equals(this.tagDescription, other.tagDescription)) {
            return false;
        }
        if (!Objects.equals(this.tagId, other.tagId)) {
            return false;
        }
        if (!Objects.equals(this.categoryId, other.categoryId)) {
            return false;
        }
        if (!Objects.equals(this.events, other.events)) {
            return false;
        }
        return true;
    }
   
    
    
}
