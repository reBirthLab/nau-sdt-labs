/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Modifier {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String fileName = "Apartment.java";
        String tempDir =  "./Temp/";

        System.out.println(tempDir);

        File input = new File(tempDir, fileName);
        File output = new File(tempDir, "mod_" + fileName);

        RandomAccessFile inputFile = new RandomAccessFile(input, "r");
        RandomAccessFile outputFile = new RandomAccessFile(output, "rw");

        String currentLine;

        while ((currentLine = inputFile.readLine()) != null) {

            System.out.println(currentLine);

            StringBuffer str = new StringBuffer(currentLine);

            int stringLength = str.length() - 1;
            int idx = 0;
            int lastIdx = 0;
            int deltaIdx;
            int spaceIdx;

            while ((spaceIdx = str.indexOf(" ", idx)) != -1) {

                // Check if a word is longer than 2 characters and if so - 
                // changes it to upper case
                deltaIdx = (spaceIdx - lastIdx) - 1;

                if (deltaIdx > 2) {
                    for (int i = 0; i <= deltaIdx; ++i) {
                        char x = str.charAt(lastIdx + i);
                        x = Character.toUpperCase(x);
                        str.setCharAt(lastIdx + i, x);
                    }
                }

                // Check if it is the last word
                if (str.lastIndexOf(" ", stringLength) == spaceIdx) {

                    deltaIdx = stringLength - spaceIdx;

                    if (deltaIdx > 2) {
                        for (int i = 0; i <= deltaIdx; ++i) {
                            char x = str.charAt(spaceIdx + i);
                            x = Character.toUpperCase(x);
                            str.setCharAt(spaceIdx + i, x);
                        }
                    }
                }

                lastIdx = spaceIdx;
                idx = spaceIdx + 1;
            }

            outputFile.writeBytes(str + "\r\n");
        }
    }
}
