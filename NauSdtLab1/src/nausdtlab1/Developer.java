/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab1;


public class Developer {
    String surname, init;
    
    public Developer(String mySurname, String myInit){
        surname = mySurname;
        init = myInit;
    }
    
    public void printName (){
        System.out.println("The developer's surname is " + surname);
        System.out.println("The developer's initials are " + init);
    }
}
