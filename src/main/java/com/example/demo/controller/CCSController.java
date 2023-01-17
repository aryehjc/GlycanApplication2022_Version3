/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.nio.charset.Charset.defaultCharset;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author aryeh
 */
@Controller 
public class CCSController {
//    @Autowired
   // ResourceLoader loader;
    
    @RequestMapping("/GraphDistributions")
    public String ShowCCSDistribution(Model model) throws IOException {

        String js_str = "";            
        
        // read the js returned by the python code 
        BufferedReader readjs = new BufferedReader(new FileReader("/home/aryeh/Downloads/plotdistributions/sample/js_frags.708.36.txt")); 
        String line = readjs.readLine();
        while(line!=null) {

            js_str += line;

            line = readjs.readLine();
        }
        
         String div_str = "";
         
         // read the div returned by the python code
         BufferedReader readdiv = new BufferedReader(new FileReader("/home/aryeh/Downloads/plotdistributions/sample/div_frags.708.36.txt"));
         String line2 = readdiv.readLine();
         while(line2!=null) {
             
             div_str += line2;
             
             line2 = readdiv.readLine();
         }
                
        model.addAttribute("js_var", js_str);
        model.addAttribute("div_var", div_str);
            
        return "GraphDistributions";
        

    }
        
        
        
}
