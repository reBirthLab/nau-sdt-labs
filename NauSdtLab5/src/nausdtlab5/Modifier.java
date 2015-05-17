/* 
 * Copyright (C) 2015 Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nausdtlab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

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
                // change it to upper case
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
