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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    
    @Column(name = "event_title")
    private String eventTitle;
    
    @Column(name = "event_description")
    private String eventDescription;  
    
    @ManyToMany(mappedBy = "events")
//    @JsonIgnore
    private List<Tag> tags;
        
    @Column(name = "event_year")
    private Integer eventYear;
    
    @Column(name = "event_day")
    private Integer eventDay;
    
    @JoinColumn(name = "icon_id")
    @ManyToOne(optional = true)
    private Icon eventIcon;
    
    public Event() {
        this.tags = null;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Integer getEventYear() {
        return eventYear;
    }

    public void setEventYear(Integer eventYear) {
        this.eventYear = eventYear;
    }

    public Integer getEventDay() {
        return eventDay;
    }

    public void setEventDay(Integer eventDay) {
        this.eventDay = eventDay;
    }

    public String getEventIcon() {
        return eventIcon.getIconName();
    }

    public void setEventIcon(Icon eventIcon) {
        this.eventIcon = eventIcon;
    }   

    public List<Tag> getTags() {
        return tags;
    }  
        
    public void addTag(Tag tag){
        for(int i = 0; i < tags.size() ; i++){
            if(tags.get(i).getTagId().equals(tag.getTagId())){
                return;
            }
        }
        this.tags.add(tag);
    }

    public void removeTag(Long id){
        for(int i = 0; i < tags.size() ; i++){
            if(tags.get(i).getTagId().equals(id)){
                tags.remove(i);
                break;
            }
        }
    }
    
    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }  

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
        final Event other = (Event) obj;
        if (!Objects.equals(this.eventTitle, other.eventTitle)) {
            return false;
        }
        if (!Objects.equals(this.eventDescription, other.eventDescription)) {
            return false;
        }
        if (!Objects.equals(this.eventIcon, other.eventIcon)) {
            return false;
        }
        if (!Objects.equals(this.eventId, other.eventId)) {
            return false;
        }
        if (!Objects.equals(this.eventYear, other.eventYear)) {
            return false;
        }
        if (!Objects.equals(this.eventDay, other.eventDay)) {
            return false;
        }
        return true;
    }
    
}
