/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Controllers;


import com.example.Entities.Icon;
import com.example.Services.IconService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class IconController {
    
    @Autowired
    private IconService service;
    
    @RequestMapping("icon-all")
    public List<Icon> getAll(){
        return service.getAllTags();
    }
}
