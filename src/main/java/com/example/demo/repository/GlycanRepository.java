package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Glycan;
// import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface GlycanRepository extends JpaRepository<Glycan, Long> {
	// This will be AUTO IMPLEMENTED by Spring into a Bean
  @Query("SELECT g FROM Glycan g WHERE CONCAT(g.id, ' ', g.databaseID, ' ', g.oxford, ' ', g.neutralmass, ' ', "
          + "g.observedmz, ' ', g.ccs1, ' ', g.observedmz2, ' ', g.ccs2) LIKE %?1%")
public Page<Glycan> findAll(String keyword, Pageable pageable);  
}
