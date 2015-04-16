/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yakovfain;

/**
 *
 * @author Anastasiy
 */
public class TestTax {
    public static void main (String[] args){
        double grossIncome; // local variables
        String state;
        int dependants;
        
        grossIncome = 50000;
        dependants = 2;
        state = "NJ";
        
        Tax t = new Tax(grossIncome, state, dependants);
        
        double yourTax = t.calcTax(); // calculating tax
        
        Tax t2 = new Tax(65000, "TX", 4);
        
        double hisTax = t2.calcTax();
        
        // Printing the result
        System.out.println("Your tax is " + yourTax);
        System.out.println("Your tax is " + hisTax);
        
        // Convert taxes in Euros
        t.convertInEuros(yourTax);
        t2.convertInEuros(hisTax);
        
        
    }
}
