/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;


import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdditionController {

    @RequestMapping("/GlycanDatabaseApp")
    public String viewForm(@ModelAttribute Addition addition,
            BindingResult result,
            Model model) {
        model.addAttribute("Addition", new Addition());
        addition.Total();
        // addition.TotalAmountOfCharge();
        System.out.println("My Total is " + addition.Total());
       // System.out.println("My Charge is " + addition.TotalAmountOfCharge());
        return "GlycanDatabaseApp";
    }
    
    @RequestMapping("/SampleCCSGraphicalData")
    public String Redirect1() {
        return "SampleCCSGraphicalData";
    }
    
        
    @RequestMapping("/SampleGlycan")
    public String Redirect2() {
        return "SampleGlycan";
    }
    // basically the thymeleaf action form must correspond to @ / action..
    // see 
@RequestMapping("/MySQLTableForGlycansAndCCS")
public String Redirect3() {
return "index";
    // make the htmls as usual and then just put them in the controller. and then add it to te 
}
}



// https://stackoverflow.com/questions/70683197/how-to-make-form-input-and-the-value-table-be-on-the-same-page-with-spring-mvc-a
// this has the addition.total() read but it doesn't redirect properly.. keep trying!
