package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Glycan;
import com.example.demo.service.GlycanService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // This means that this class is a Controller
public class GlycanController {

	@Autowired
	// This means to get the bean which is auto-generated by Spring
	// We will use an glycanService for each
	GlycanService glycanService;

	//	display list of glycans
	@GetMapping("/MySQLTableForGlycansAndCCS")
	// This means that this method will be executed when user sends GET Requests to "/"
	// In our case, "http://localhost:8080/"
	public String viewHomePage(Model model) {

		//	We can use this attribute "listGlycans" to perform server-side rendering of the HTML with using Thymeleaf.
		//	We set all glycans data to "listGlycans"
		model.addAttribute("listGlycans", glycanService.getAllGlycans());

		//		shows the index.html template:
		return "index";
	}

	//	showNewGlycanForm
	@GetMapping("/showNewGlycanForm")
	// This means that this method will be executed when user sends GET Requests to "/showNewGlycanForm"
	// In our case,  "http://localhost:8080/showNewGlycanForm"
	public String showNewGlycanForm(Model model) {
		Glycan glycan = new Glycan();

		// We can use this attribute "glycan" to perform server-side rendering of the HTML with using Thymeleaf.
		model.addAttribute("glycan", glycan);

		//	shows the new_glycan.html template:
		return "new_glycan";
	}

	//	add an glycan - from codejava net tutorial start here for image upload.
        @PostMapping("/saveGlycan")
	// This means that this method will be executed when user sends POST Requests to "/saveGlycan"
	// In our case, "http://localhost:8080/saveGlycan"
	public String saveGlycan(@ModelAttribute("glycan") Glycan glycan) {
		//	@ModelAttribute  binds the object called "glycan" of request body from the POST request into the glycan parameter of the saveGlycan() method.
                
            glycanService.saveGlycan(glycan); 
            
            
           
		// after save the glycan data to database, redirect to "/"
		return "redirect:/MySQLTableForGlycansAndCCS";
	}
// return "redirect:/MySQLTableForGlycansAndCCS";
	//	show update form
	@GetMapping("/showGlycanFormForUpdate/{id}")
	// This means that this method will be executed when user sends GET Requests to "/showFormForUpdate/{glycan's id}"
	// In our case, "http://localhost:8080/showFormForUpdate/{glycan's id}"
	public String showGlycanUpdateForm(@PathVariable Long id, Model model) {
		// @PathVariable binds the {id} which the path of GET request contains into the id parameter of showUpdateForm() method.

		Glycan glycan = glycanService.getGlycanById(id);

		//	We can use this attribute "glycan" to perform server-side rendering of the HTML with using Thymeleaf.
		//	We set glycan data to "glycan"
		model.addAttribute("glycan", glycan);

		//	shows the update_glycan.html template:
		return "update_glycan";
	}

	//	delete the glycan by id
	@GetMapping("/delete/{id}")
	// This means that this method will be executed when user sends GET Requests to "/delete/{glycan's id}"
	//	In our case, "http://localhost:8080/delete/{glycan's id}"
	public String deleteGlycanById(@PathVariable Long id, Model model) {
		glycanService.deleteGlycanById(id);

	//	after delete the glycan data from database, redirect to "/"
		return "redirect:/MySQLTableForGlycansAndCCS";
	}
        
        
    
	//	delete the glycan by id
	@GetMapping("/deleteAll")
	// This means that this method will be executed when user sends GET Requests to "/delete/{glycan's id}"
	//	In our case, "http://localhost:8080/delete/{glycan's id}"
	public String deleteAllGlycans() {
		glycanService.deleteAllGlycans();

	//	after delete the glycan data from database, redirect to "/"
		return "redirect:/MySQLTableForGlycansAndCCS";
	}
        
        
      @RequestMapping("/GlycanDictionary")
public String RedirectGlycan() {
return "GlycanDictionary";
    // make the htmls as usual and then just put them in the controller. and then add it to te 
}

      @RequestMapping("/uploadPage")
public String RedirectGlycanNew() {
return "uploadPage";
    // make the htmls as usual and then just put them in the controller. and then add it to te 
}



}
