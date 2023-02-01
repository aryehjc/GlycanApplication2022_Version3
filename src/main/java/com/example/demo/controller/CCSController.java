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


import java.io.*;
import com.example.demo.utils.PythonUtils;
import com.graphbuilder.math.func.PowFunction;
import java.io.InputStreamReader;
import javax.security.sasl.Sasl;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
/**
 *
 * @author aryeh
 */
@Controller 
public class CCSController {
//    @Autowired
   // ResourceLoader loader;
    
    @RequestMapping("/GraphDistributions")
    public String ShowCCSDistribution(Model model,@RequestParam("file") MultipartFile mfile,  @RequestParam("file2") MultipartFile mfile2, HttpSession session) throws Exception {

        String sesson_path = session.getServletContext().getRealPath("/");     // this is the location of the directory the file will be placed
        String session_tmp_file = mfile.getOriginalFilename();       // this is the tmepory file name (i think)       
        String session_tmp_file2 = mfile2.getOriginalFilename();
            
        
        // create a random directory for this session
        int min = 1; // Minimum value of range
        int max = 100000; // Maximum value of range      
        // Generate random int value from min to max
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);

        
        String workdir = sesson_path + "sample_" + random_int + "/";
        File theDir = new File(workdir);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        else {
            System.out.println("Report back to front end an error saying this directory already exists (unlikely event");           
        }
        
        
        System.out.println(sesson_path + "/" + session_tmp_file);
        
        
        File file_to_webapp_dir = new File(workdir + "/" + session_tmp_file);
        mfile.transferTo(file_to_webapp_dir);
        File file_to_webapp_dir2 = new File(workdir + "/" + session_tmp_file2);
        mfile2.transferTo(file_to_webapp_dir2);
        
        
        
        // 1. run the python script on tzhe file now knowing that it is located at sesson_path + "/" + session_tmp_file                        
        
        // these variables are hardcoded to be the location of the pythioon environment with scripts and files
        String hardcoded_python_location = "/home/aryeh/Downloads/demo/plotdistributions/";        
        String python_venv = hardcoded_python_location + "/py39/bin/python3.9";
        String pythn_script = hardcoded_python_location + "/CCSDistribution.py";
        String library_location = hardcoded_python_location + "/library_distributions/frags_available.csv";
        ////////////////////////////////
        
        
        // these are supplied by the app and the user
        String usermass_to_search_for = "708.33";   
        //////
        
        
        
        PythonUtils py  = new PythonUtils();
        System.out.println("TRYING: " + pythn_script + " " + workdir + " " + usermass_to_search_for + " 1 0.2 " + library_location);
        py.executePythonScript(python_venv, new File(pythn_script), " " + workdir + " " + usermass_to_search_for + " 1 0.2 " + library_location);
        
        
        // read the js returned by the python code 
        String js_str = "";       
        BufferedReader readjs = new BufferedReader(new FileReader(workdir + "/js_frags."+usermass_to_search_for+".txt")); 
        String line = readjs.readLine();
        while(line!=null) {

            js_str += line;

            line = readjs.readLine();
        }
        
         String div_str = "";
         
         // read the div returned by the python code
         BufferedReader readdiv = new BufferedReader(new FileReader(workdir + "/div_frags."+usermass_to_search_for+".txt"));
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
