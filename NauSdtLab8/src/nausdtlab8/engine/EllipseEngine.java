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
package nausdtlab8.engine;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import javafx.application.Platform;
import javafx.concurrent.Task;
import nausdtlab8.gui.PursuerGUIController;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class EllipseEngine extends Task<Void> {

    private final PursuerGUIController gui;
    private Point currentClicked;
    private Point ellipsePosition;
    private double deltaX;
    private double deltaY;
    private double incX;
    private double incY;
    private volatile boolean running = true;

    public EllipseEngine(PursuerGUIController gui) {
        this.gui = gui;
    }

    private double xIncrement() {
        return abs(deltaX / sqrt(pow(deltaX, 2) + pow(deltaY, 2)));
    }

    private double yIncrement() {
        return abs(deltaY / sqrt(pow(deltaX, 2) + pow(deltaY, 2)));
    }

    @Override
    protected Void call() throws Exception {
        currentClicked = gui.getClickedPoint();
        ellipsePosition = gui.getEllipsePosition();

        while (running) {
            deltaX = ellipsePosition.getX() - currentClicked.getX();
            deltaY = ellipsePosition.getY() - currentClicked.getY();
            incX = xIncrement()*0.5;
            incY = yIncrement()*0.5;

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if ((int) deltaX != 0 || (int) deltaY != 0) {
                        if (deltaX > 0) {
                            if (deltaY > 0) {
                                ellipsePosition.setX(ellipsePosition.getX() - incX);
                                ellipsePosition.setY(ellipsePosition.getY() - incY);                               
                            } else if (deltaY < 0) {
                                ellipsePosition.setX(ellipsePosition.getX() - incX);
                                ellipsePosition.setY(ellipsePosition.getY() + incY);                               
                            }
                        } else if (deltaX < 0) {
                            if (deltaY > 0) {
                                ellipsePosition.setX(ellipsePosition.getX() + incX);
                                ellipsePosition.setY(ellipsePosition.getY() - incY);                               
                            } else if (deltaY < 0) {
                                ellipsePosition.setX(ellipsePosition.getX() + incX);
                                ellipsePosition.setY(ellipsePosition.getY() + incY);                                
                            }
                        }
                        gui.setEllipsePosition(ellipsePosition);
                        gui.setEllipseLabelText(ellipsePosition);
                    } else {                      
                        running = false;
                    }
                }
            });

            Thread.sleep(2);
        }
        return null;

    }
}
