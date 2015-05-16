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
package nausdtlab3;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Apartment {

    // Class fields
    private int id;
    private int number;
    private double grossArea;
    private int floor;
    private int numberOfRooms;
    private String streetName;
    private String typeOfBuilding;
    private int expoitationTime;

    // Constructors
    public Apartment() {
        // TODO: Write default constructor
    }

    public Apartment(int id, int number, double grossArea,
            int floor, int numberOfRooms, String streetName,
            String typeOfBuilding, int expoitationTime) {

        this.id = id;
        this.number = number;
        this.grossArea = grossArea;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.streetName = streetName;
        this.typeOfBuilding = typeOfBuilding;
        this.expoitationTime = expoitationTime;

    }

    // Methods for setting class fields
    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGrossArea(double area) {
        grossArea = area;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setNumberOfRooms(int rooms) {
        numberOfRooms = rooms;
    }

    public void setStreet(String street) {
        streetName = street;
    }

    public void setTypeOfBuilding(String type) {
        typeOfBuilding = type;
    }

    public void setExploitationTime(int years) {
        expoitationTime = years;
    }

    // Method for getting class fields
    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public double getGrossArea() {
        return grossArea;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getStreet() {
        return streetName;
    }

    public String getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public int getExploitationTime() {
        return expoitationTime;
    }

    public void printData() {
        System.out.println("Apartment ID: " + id + "\n" 
                +"Number: " + number + ", Area: " + grossArea
                + ", Floor: " + floor + ", Rooms: " + numberOfRooms
                + ", Street: " + streetName + ",\n"
                + "Type of building: " + typeOfBuilding
                + ", Years of expluatation: " + expoitationTime + "\n");
    }
}
