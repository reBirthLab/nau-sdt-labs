/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab8;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class EllipseEngine extends Task<Void> {

    private final PursuerGUIController gui;
    private Point currentClicked;
    private Point currentEllipsePosition;
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
        currentEllipsePosition = gui.getEllipsePosition();

        while (running) {
            deltaX = currentEllipsePosition.x - currentClicked.x;
            deltaY = currentEllipsePosition.y - currentClicked.y;
            incX = xIncrement()*0.5;
            incY = yIncrement()*0.5;

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if ((int) deltaX != 0 || (int) deltaY != 0) {
                        if (deltaX > 0) {
                            if (deltaY > 0) {
                                currentEllipsePosition.x -= incX;
                                currentEllipsePosition.y -= incY;
                                gui.setEllipsePosition(currentEllipsePosition);
                            } else if (deltaY < 0) {
                                currentEllipsePosition.x -= incX;
                                currentEllipsePosition.y += incY;
                                gui.setEllipsePosition(currentEllipsePosition);
                            }
                        } else if (deltaX < 0) {
                            if (deltaY > 0) {
                                currentEllipsePosition.x += incX;
                                currentEllipsePosition.y -= incY;
                                gui.setEllipsePosition(currentEllipsePosition);
                            } else if (deltaY < 0) {
                                currentEllipsePosition.x += incX;
                                currentEllipsePosition.y += incY;
                                gui.setEllipsePosition(currentEllipsePosition);
                            }
                        }
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
