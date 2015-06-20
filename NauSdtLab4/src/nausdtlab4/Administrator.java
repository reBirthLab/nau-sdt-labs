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
public class Administrator extends Human {

    public Administrator(String name) {
        super(name);
    }

    public void formCrew(Flight flight, String name) {
        Crew crew = new Crew(name);
        flight.setCrew(crew);
        System.out.println(crew.getName() + " has been successfully set to flight "
                + flight.getName() + "!\n");
    }

    public void setPlaneForFlight(Flight flight, Plane plane) {
        Airport destination = flight.getDestination();
        int flightDistance = destination.getDistance();
        int flightCapacity = flight.getCapacity();

        int planeCapacity = plane.getCapacity();
        int planeRange = plane.getRange();

        if (flightDistance < planeRange 
                && flightCapacity < planeCapacity
                && !plane.isBusy()) {
            flight.setPlane(plane);
            plane.setBusy();
            
            System.out.println(plane.getName()
                    + " has been successfully set to flight " + flight.getName() + "!\n");
        } else {
            System.out.println(plane.getName()
                    + " cannot be set for flight " + flight.getName() + ".\n");
        }
    }
    
    public void cancelFlight(Flight flight){
        flight.cancelFlight();
    }
}
