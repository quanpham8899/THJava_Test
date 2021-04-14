/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanPham;

import java.text.DecimalFormat;

/**
 *
 * @author ASUS FX504
 */
public class NewClass {
    DecimalFormat formatter = new DecimalFormat();
    
    public static void main(String[] args) {
        String s = "2,555";    
        String newString = "";
        for(int i = 0; i < s.length(); i+= 1) {
            if (s.charAt(i) == ','){
                continue;
            }
            newString += s.charAt(i);
        }
        
        System.out.println("Result : " + newString);
    }
    
}
