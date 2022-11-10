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
  @Query("SELECT g FROM Glycan g WHERE CONCAT(g.id, ' ', g.DatabaseID, ' ', g.Oxford, ' ', g.NeutralMass, ' ', "
          + "g.ObservedMZ, ' ', g.CS_M_Plus_2H_Charge_2, ' ', g.ObservedMZ2, ' ', g.CCS_M_Plus_H_Plus_Na_Charge_2) LIKE %?1%")
public Page<Glycan> findAll(String keyword, Pageable pageable);  
}
