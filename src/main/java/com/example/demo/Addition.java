/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;


public class Addition {
    
    private float num1;
    private float num2;
    private float num3;
    private float num4;
    private float num5;
    private float num6;
    private float num7;
    private float num8;
    private float num9;
    private float num10;


    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }
    
    public float getNum3() {
        return num3;
    }

    public void setNum3(float num3) {
        this.num3 = num3;
    }


    public float getNum4() {
        return num4;
    }


    public void setNum4(float num4) {
        this.num4 = num4;
    }


    public float getNum5() {
        return num5;
    }


    public void setNum5(float num5) {
        this.num5 = num5;
    }


    public float getNum6() {
        return num6;
    }


    public void setNum6(float num6) {
        this.num6 = num6;
    }


    public float getNum7() {
        return num7;
    }


    public void setNum7(float num7) {
        this.num7 = num7;
    }


    public float getNum8() {
        return num8;
    }


    public void setNum8(float num8) {
        this.num8 = num8;
    }


    public float getNum9() {
        return num9;
    }


    public void setNum9(float num9) {
        this.num9 = num9;
    }
    
    

    public float getNum10() {
        return num10;
    }


    public void setNum10(float num10) {
        this.num10 = num10;
    }
    
    
    
    public float Total()  {
        

        return (num1 + num2 + num3 + (3 * num4) + (2 * num5) + num6 + 
        num7 + num8 + num9) / num10;
  
    }
    
       // public float TotalAmountOfCharge() {
    
        // return num10;
    
}
    


        
        // i think the numbers above are not accessible on 2nd page, thats why 
// my class didnt work. i need to find a way to make them accessible.

  

            
            
    


    

    
  //  public float getCharge() {
        // return num10;
   // }
    
  //  public float getNumHexose() {
        // return num4;
    //} 
    
// I want to do this and define all my parameters... num1 to num9
// With my Hexose x 3, Hexnac x 2 .. num4 * 3, num5 * 2.
// and then get a basic mass calculation (first part done)
// i think edit the sum here to decimal. Float getter and setters. It works!
// now add a num10 for divisor, put if && rules on it and then get the solution on the next page.
//might need to wrap my if loops in the final total function or make a separate series and redeclare.
// either exec 1 function with all if .. else if conditions
//or 3 different functions so they don't mix up