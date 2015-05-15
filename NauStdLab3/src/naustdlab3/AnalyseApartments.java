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
package naustdlab3;

import java.util.Random;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class AnalyseApartments {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random randGen = new Random();

        int length = randGen.nextInt(15) + 5;
        Apartment[] apts = new Apartment[length];

        int[] nums = {45, 48, 51, 55, 59};
        double[] areas = {56.3, 67.6, 45.2, 65.7, 86.4};
        int[] floors = {1, 3, 5, 7, 9};
        int[] rooms = {1, 2, 3, 4, 5};
        String[] streets = {"Baker St.", "River St.", "Piccadilly St.",
            "Hill St.", "King's Bridge St."};
        String[] types = {"private", "municipal", "condemned"};
        int[] years = {20, 28, 35, 55, 87};

        for (int i = 0; i < apts.length; i++) {
            apts[i] = new Apartment();
            apts[i].setId(i);
            apts[i].setNumber(nums[randGen.nextInt(nums.length)]);
            apts[i].setGrossArea(areas[randGen.nextInt(areas.length)]);
            apts[i].setFloor(floors[randGen.nextInt(floors.length)]);
            apts[i].setNumberOfRooms(rooms[randGen.nextInt(rooms.length)]);
            apts[i].setStreet(streets[randGen.nextInt(streets.length)]);
            apts[i].setTypeOfBuilding(types[randGen.nextInt(types.length)]);
            apts[i].setExploitationTime(years[randGen.nextInt(years.length)]);
        }

        for (Apartment apt : apts) {
            apt.printData();
        }
    }
}
