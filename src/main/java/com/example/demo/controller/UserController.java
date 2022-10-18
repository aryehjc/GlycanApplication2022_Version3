/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Glycan;
import com.example.demo.repository.GlycanRepository;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aryeh
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    public final GlycanRepository repoupload;
    
    
    

    @PostMapping(value = "/upload", consumes = "text/csv")
    public ModelAndView uploadSimple(@RequestBody InputStream body, ModelMap model, Object glycanCSV) throws IOException {
        repoupload.saveAll(CsvUtils.read(Glycan.class, body));
        
        		model.addAttribute("glycan", glycanCSV);

		//	shows the update_glycan.html template:
		return new ModelAndView("redirect:/MySQLTableForGlycansAndCCS", model);
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ModelAndView uploadMultipart(@RequestParam("file") MultipartFile file, ModelMap model, Object glycanCSV) throws IOException {
        repoupload.saveAll(CsvUtils.read(Glycan.class, file.getInputStream()));
        
                		model.addAttribute("glycan", glycanCSV);

		//	shows the update_glycan.html template:
		return new ModelAndView("redirect:/MySQLTableForGlycansAndCCS", model);
        
    }
   

}
