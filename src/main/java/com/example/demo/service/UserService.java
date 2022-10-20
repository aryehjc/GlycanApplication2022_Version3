/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Glycan;
import com.example.demo.repository.GlycanRepository;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author aryeh
 */
@Service
@Validated
@RequiredArgsConstructor
public class UserService {
    public final GlycanRepository repoupload;
    public void saveAll(@Valid List<Glycan> users) {
        repoupload.saveAll(users);
    }
} 
