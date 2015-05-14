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

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Apartment {

    // Class fields
    private int id;
    private int apartmentNumber;
    private double grossArea;
    private int floor;
    private int numberOfRooms;
    private String street;
    private String typeOfBuilding;
    private int expoitationTime;

    // Constructor
    public Apartment() {

    }

    // Methods for setting class fields
    public void setId(int id) {
        this.id = id;
    }

    public void setApartmentNumber(int number) {
        apartmentNumber = number;
    }

    public void setGrossArea(double area) {
        grossArea = area;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
