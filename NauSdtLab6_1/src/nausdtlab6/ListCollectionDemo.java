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
package nausdtlab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class ListCollectionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numberOfItems;
        int n;
        String directionChoice;
        String continueChoice;
        boolean moveDown = true;
        boolean continueMod = true;

        Scanner input = new Scanner(System.in);

        List<Item> items = new ArrayList<>();

        System.out.print("***Creating list of Item objects...\n\n"
                + "Enter number of items to create > ");
        numberOfItems = input.nextInt();

        for (int i = 0; i < numberOfItems; i++) {
            items.add(new Item(i + 1));
        }

        System.out.println("\nPrinting List...");
        for (Item item : items) {
            System.out.print("Index " + items.indexOf(item) + ": ");
            if (item != null) {
                item.printId();
            }
        }
        while (continueMod) {
            System.out.print("\n\n***Moving list...\n\n"
                    + "Choose moving direction (U/D) > ");
            directionChoice = input.next().toUpperCase();
            switch (directionChoice) {
                case "U":
                    moveDown = false;
                    break;
                case "D":
                    moveDown = true;
                    break;
            }

            System.out.print("Enter moving distance > ");
            n = input.nextInt();

            if (moveDown) {
                for (int i = 0; i < n; i++) {
                    for (int j = items.size() - 1; j > 0; j--) {
                        Collections.swap(items, j, j - 1);
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < items.size() - 1; j++) {
                        Collections.swap(items, j, j + 1);
                    }
                }
            }

            System.out.println("\nPrinting List...");
            for (Item item : items) {
                if (item != null) {
                    System.out.print("Index " + items.indexOf(item) + ": ");
                    item.printId();
                }
            }

            System.out.print("\nContinue? (Y/N) > ");
            continueChoice = input.next().toUpperCase();
            switch (continueChoice) {
                case "Y":
                    continueMod = true;
                    break;
                case "N":
                    continueMod = false;
                    break;
            }
        }

        System.out.println("\nShutdown..");
    }

}
