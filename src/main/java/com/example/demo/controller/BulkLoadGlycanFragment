/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Glycan;
import com.example.demo.repository.GlycanRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aryeh
 */
@RestController
public class BulkLoadGlycanFragment {
@Autowired
GlycanRepository glycanRepository;

    @GetMapping("/saveAllGlycans")
    public ModelAndView insertGlycans(ModelMap model) {        
        Glycan c1 = new Glycan("3952", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c2 = new Glycan("4659", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c3 = new Glycan("5081", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c4 = new Glycan("5267", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c5 = new Glycan("5577", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c6 = new Glycan("5897", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c7 = new Glycan("1413", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c8 = new Glycan("1994", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c9 = new Glycan("635", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c10 = new Glycan("636", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c11 = new Glycan("fragment1", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        Glycan c12 = new Glycan("fragment2", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759");
        List<Glycan> glycans = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
        glycanRepository.saveAll(glycans);
        return new ModelAndView("redirect:/MySQLTableForGlycansAndCCS", model);
    }






}
