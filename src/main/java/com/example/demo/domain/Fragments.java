/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

/**
 *
 * @author aryeh
 */
public class Fragments {
    
    private String fragments_file;
    private String glycanid;
            
    
    public Fragments() {

    }
    
    public String getFileName() {
        return fragments_file;
    }

    public void setFileName(String f) {
        this.fragments_file = f;
    }
  
    public String getGlycanid() {
        return this.glycanid;
    }

    public void setGlycanid(String id) {
        this.glycanid = id;
    }
}
