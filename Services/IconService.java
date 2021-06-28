/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Services;

import com.example.Entities.Icon;
import com.example.Repository.IconRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IconService {

    @Autowired
    private IconRepository repository;
    
    public List<Icon> getAllTags() {
        return repository.findAll();
    }
    
}
