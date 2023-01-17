/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import java.io.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Fragments;
import com.example.demo.domain.Glycan;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

/**
 *
 * @author aryeh
 */

@Controller // This means that this class is a Controller
public class FragmentsController {
    
    
    // instance variables (also known as class variables)
    public Fragments frags;    
    private int is_sialyated_6 = 0;
    private int is_sialyated_3 = 0;
    
    
    @RequestMapping(value = "/fragments", method = RequestMethod.POST)
    public String fillFragInfo(@RequestParam String glycanid, Model model) throws IOException {
        

        frags = new Fragments();    // bean 
        frags.setGlycanid(glycanid);
      
    
        // get the location of FRAGMENTS.csv config file
        ClassPathResource cp = new ClassPathResource("static/FRAGMENT.csv", this.getClass().getClassLoader());
        File f = cp.getFile();
        
        String frag_location = f.getPath();
        frags.setFileName(frag_location);   
        
        
        
        // 1. read the FRAGMENTS.csv file 
        // 2. find the row with the glycan id
        // 3. if the sialyted fragment is 1 then report back to jquery
        isSialytedFrag(frags);
        
        
        model.addAttribute("frags", frags);
        model.addAttribute("s6", this.is_sialyated_6);
        model.addAttribute("s3", this.is_sialyated_3);
        
        // in model object set the sialted_6 and sialated_3 variables to be read by front end and then display in th or js,
        // if it is 0, if it is not 0, if both are 0, then display model and view on the frontend
        //if 3 = 0, 6= 0 etc. then show and if not show error.
        //	shows the update_glycan.html template:
        if(this.is_sialyated_6 == 0 && this.is_sialyated_3 == 0) {
            return "error-500";
        }

        
        return "fragDetails"; // this is default and as they don't have a value it gives the normal page.
    }
    
    
    
    public void isSialytedFrag(Fragments f) {
        
        System.out.println("Fragments ID = " + f.getGlycanid());
        
        try {
            
            FileReader freader = new FileReader(f.getFileName());
            BufferedReader readcsv = new BufferedReader(freader);
            
            String line = readcsv.readLine();
            String[] entries = null;
            while(line!=null) {
                
                entries = line.split(",");
                System.out.println(entries[0]);
                
                if(entries[0].equalsIgnoreCase(f.getGlycanid())) {
                    // line in file is the row we want
                    if(entries[1].equals("1")) {
                        //it is a sialted 6
                        this.is_sialyated_6 = 1;
                    } else {
                        this.is_sialyated_6 = 0;
                    }
                    
                    
                    if(entries[2].equals("1")) {
                        // it is sialyted 3
                        this.is_sialyated_3 = 1;
                    }
                    else {
                        this.is_sialyated_3 = 0;
                    }
                    


                }
                
                line = readcsv.readLine();
            }
            
            
            readcsv.close();
            
            
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    
    }

    
    

}
