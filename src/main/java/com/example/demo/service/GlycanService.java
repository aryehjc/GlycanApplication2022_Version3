package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.domain.Glycan;
import com.example.demo.repository.GlycanRepository;

@Service // This means that this class is a service
public class GlycanService {
	@Autowired
	// to get the bean which is auto-generated by Spring
	//	We will use it to handle the data
	GlycanRepository glycanRepository;

	//	get all glycans
	public List<Glycan> getAllGlycans() {

		//		find all glycans data, then return it
		return glycanRepository.findAll();
	}

	// save an glycan
	public void saveGlycan(Glycan gly) {

      		glycanRepository.save(gly);
            }
		//		save glycan data to database

	

	//	get glycan by id
	public Glycan getGlycanById(Long id) {
		//		find an glycan by id
		Glycan gly = glycanRepository.getById(id);

		//		if there is not an glycan who has the id, throw the error.
		if (gly == null) {
			throw new RuntimeException("Glycan not found");
		}
		return gly;
	}

	//	delete glycan by id
	public String deleteGlycanById(Long id) {
		//		find an glycan by id
		Glycan gly = glycanRepository.getById(id);

		//		if there is not an glycan who has the id, throw the error.
		if (gly == null) {
			throw new RuntimeException("Glycan not found");
		}

        //		delete an glycan who has the id from the database 
        glycanRepository.deleteById(id);
        return "Deleted: " + gly.getDatabaseID()+ " " + gly.getOxford()+ " " 
                + gly.getNeutralMass()+ " " + gly.getObservedMZ()+ " " + gly.getCS_M_Plus_2H_Charge_2()+ " " 
                + gly.getObservedMZ()+ " " + gly.getCCS_M_Plus_H_Plus_Na_Charge_2();
    }
       
}


// might need to add one more for photo.
// 		return "Deleted: " + gly.getGlycanName() + " " + gly.getProtons();
