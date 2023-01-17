/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author aryeh
 */
@Controller // This means that this class is a Controller
public class SearchController {
    
    
    private String mass;
    private String tolerance;
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String fillFragInfo(@RequestParam String mass, @RequestParam String tolerance, Model model) throws IOException {
        
        System.out.println("Mass was correctly passed to java: " + mass);
        System.out.println("Mass was correctly passed to java: " + tolerance);
        
        float mass_number = Float.parseFloat(mass);
        float tolerance_number = Float.parseFloat(tolerance);
        
        float lowermass = mass_number - tolerance_number;
        float uppermass = mass_number + tolerance_number;
        System.out.println("Now I will search SQL for all masses in the range: " + lowermass + " - " + uppermass);
        
        
        /// query SQL by netral mass , do between range and see if it works 
        // https://www.google.com/search?channel=fs&client=ubuntu&q=sql+search+by+range+
        // and then we can search it by range and try 
        
        // in model we add variables that will be passed back to timeleaf , fix template
        
        
     return "MySQLTableForGlycansAndCCS";   
    }
}
