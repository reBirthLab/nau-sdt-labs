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
public class Flight {
    private final String name;
    private final int capacity;
    private Airport destination;
    private Plane plane;
    private Crew crew;
    private boolean isActive;
    
    

    public Flight(String name, Airport destination, int capacity) {
        this.name = name;
        this.destination = destination;
        this.capacity = capacity;
        isActive = true;
        System.out.println("Flight " + name + " to " + destination.getName()
                + " for " + capacity + " persons has been successfully created!\n");
    }
    
    public void setCrew(Crew crew){
        this.crew = crew;
    }
    
    public void setPlane(Plane plane){
        this.plane = plane;
    }
    
    public void changeDestination (Airport newDestination){
        destination = newDestination;
        System.out.println("Flight " + name + " changes destination to " 
                + newDestination.getName() + " due to technical problems.\n");
    }
    
    public void cancelFlight(){
        isActive = false;
        System.out.println("Flight " + name + " is cancelled due to weather conditions.\n" );
    }
    
    public String getName(){
        return name;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public Airport getDestination(){
        return destination;
    }
    
    public Plane getPlane(){
        return plane;
    }
}
    
    
