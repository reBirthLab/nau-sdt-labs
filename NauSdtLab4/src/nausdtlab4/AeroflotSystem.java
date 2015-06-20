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
package nausdtlab4;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class AeroflotSystem {

    private final static Airport JFK = new Airport("JFK", 7897);
    private final static Airport LHR = new Airport("LHR", 2896);
    private final static Airport HAM = new Airport("HAM", 2087);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Aeroflot System!\n");
        
        //Create fleet of planes
        Plane plane1 = new Plane("P001-B737", 189, 5767);
        Plane plane2 = new Plane("P002-A310", 220, 8056);
        Plane plane3 = new Plane("P003-A318", 132, 6019);
        
        //Create administrator
        Administrator admin = new Administrator("Admin");

        //Create new flights to New York and London
        Flight flightToNY = new Flight("NY7500", JFK, 160);
        Flight flightToLondon = new Flight("LHR757", LHR, 180);

        //Administrator forms a new crew to the flights
        admin.formCrew(flightToNY, "Crew N10");
        admin.formCrew(flightToLondon, "Crew L10");

        //Set suitable plane to the NY flight (first attempt)
        admin.setPlaneForFlight(flightToNY, plane1);
        //Set suitable plane to the NY flight (second attempt)
        admin.setPlaneForFlight(flightToNY, plane2);
        
        //Set suitable plane to the London flight (first attempt)
        admin.setPlaneForFlight(flightToLondon, plane2);
        //Set suitable plane to the London flight (second attempt)
        admin.setPlaneForFlight(flightToLondon, plane1);
        
        //Administatator cancels flight to London due to bad weather conditions
        admin.cancelFlight(flightToLondon);
        
        //Change of destination
        flightToNY.changeDestination(HAM);

    }

}
