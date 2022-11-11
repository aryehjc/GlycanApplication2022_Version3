package com.example.demo.service;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.domain.Glycan;
import com.example.demo.repository.GlycanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service // This means that this class is a service
public class GlycanService {
	@Autowired
	// to get the bean which is auto-generated by Spring
	//	We will use it to handle the data
	GlycanRepository glycanRepository;

	//	get all glycans
	public Page<Glycan> listAll(int pageNumber, String sortField, String sortDir, String keyword) {
            Sort sort = Sort.by(sortField);
            sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
            
            Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort);
            
            if (keyword != null) { 
                return glycanRepository.findAll(keyword, pageable);
            }
            
		//		find all glycans data, then return it
		return glycanRepository.findAll(pageable);
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
                + gly.getNeutralmass()+ " " + gly.getObservedmz()+ " " + gly.getCcs1()+ " " 
                + gly.getObservedmz2()+ " " + gly.getCcs2();
    }
        
        
        	//	delete ALL glycan by id
	public void deleteAllGlycans() {
		//		find an glycan by id
		glycanRepository.deleteAllInBatch();

		// server side prevents 404 on multiple button press,.	if there is not an glycan who has the id, throw the error.

}
        
}


// might need to add one more for photo.
// 		return "Deleted: " + gly.getGlycanName() + " " + gly.getProtons();
