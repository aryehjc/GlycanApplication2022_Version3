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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author aryeh
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    public final GlycanRepository repoupload;
    
    
    

    @PostMapping(value = "/upload", consumes = "text/csv")
    public void uploadSimple(@RequestBody InputStream body) throws IOException {
        repoupload.saveAll(CsvUtils.read(Glycan.class, body));
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
        repoupload.saveAll(CsvUtils.read(Glycan.class, file.getInputStream()));
    }
}