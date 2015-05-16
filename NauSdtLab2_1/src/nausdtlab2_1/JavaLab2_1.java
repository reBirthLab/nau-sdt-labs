/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab2_1;

/**
 *
 * @author Anastasiy
 */
public class JavaLab2_1 {

    StringBuffer text;
    String charX;
    char beReplaced;
    char replaceWith;
    
    public void replaceDefinedCharNextToCharX (StringBuffer text, String charX, char beReplaced, char replaceWith){
        
        this.text = text;
        this.charX = charX;
        this.beReplaced = beReplaced;
        this.replaceWith = replaceWith;
        
        int i = 0;
        int posX;

        while ((posX = text.indexOf(charX, i)) != -1) {
            int nextToX = posX + 1;
            int nextNextToX = posX + 2;
            if (text.charAt(nextNextToX) != ' ' && text.charAt(nextToX) == beReplaced) {
                text.setCharAt(nextToX, replaceWith);
            }
            i = nextToX;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        StringBuffer text = 
                new StringBuffer("\"Would you tell me, please, which way I ought to go from here?\"\n"
                + "\"That depends a good deal on where you want to get to.\"\n"
                + "\"I don't much care where –\"\n"
                + "\"Then it doesn't matter which way you go.\"\n"
                + "-- Lewis Carroll, Alice in Wonderland");

        System.out.println(text);

        // TASK:
        // If 'r' is not last in a word and after it stands 'O' then change 'O' to 'e'.
        
        String charR = "g";
        char replaceO = 'o';
        char replaceWithE = 'O';
        
        JavaLab2_1 lab2 = new JavaLab2_1();
        
        lab2.replaceDefinedCharNextToCharX (text, charR, replaceO, replaceWithE);
        
        System.out.println("\n\n" + text);
    }

}
