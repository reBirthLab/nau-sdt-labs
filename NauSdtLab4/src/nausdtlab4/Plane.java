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
public class Plane {
    private final String name;
    private final int capacity;
    private final int flyingRange;
    private boolean isBusy;

    public Plane(String name, int capacity, int flyingRange) {
        this.name = name;
        this.capacity = capacity;
        this.flyingRange = flyingRange;
        
        isBusy = false;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public int getRange(){
        return flyingRange;
    }
    
    public boolean isBusy(){
        return isBusy;
    }
    
    public void setBusy(){
        isBusy = true;
    }
}
