package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Glycan;

@Repository
public interface GlycanRepository extends JpaRepository<Glycan, Long> {
	// This will be AUTO IMPLEMENTED by Spring into a Bean
    
}