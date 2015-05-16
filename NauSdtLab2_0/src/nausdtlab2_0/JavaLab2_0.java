/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab2_0;

/**
 *
 * @author Anastasiy
 */
public class JavaLab2_0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuffer text
                = new StringBuffer("\"Would you tell me, please, which way I ought to go from herO?\"\n"
                        + "\"That depends a good deal on wherO you want to get to.\"\n"
                        + "\"I don't much carO wherO –\"\n"
                        + "\"Then it doesn't matter which way you go.\"\n"
                        + "-- Lewis Carroll, Alice in Wonderland");

        System.out.println(text);

        // TASK:
        // If 'r' is not last in a word and after it stands 'O' then change 'O' to 'e'.
        String charX = "r";
        char beReplaced = 'O';
        char replaceWith = 'e';

        int i = 0;
        int posX;

        while ((posX = text.indexOf(charX, i)) != -1) {
            int nextToX = posX + 1;
            if (text.charAt(nextToX) != ' ' && text.charAt(nextToX) == beReplaced) {
                text.setCharAt(nextToX, replaceWith);
            }
            i = nextToX;
        }

        System.out.println("\n\n" + text);
    }

}
