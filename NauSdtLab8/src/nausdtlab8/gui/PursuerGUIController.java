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
package nausdtlab8.gui;

import nausdtlab8.engine.EllipseEngine;
import nausdtlab8.engine.Point;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class PursuerGUIController implements Initializable {

    private final Random rand = new Random();
    private final Point clicked = new Point(0.0, 0.0);
    private final DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("en"));
    private final DecimalFormat decimal = new DecimalFormat("#.0", symbols);
    private Thread engine;
    private EllipseEngine moveEllipse;
    private int clickCounter = 0;
    private boolean threadRunning = false;

    @FXML
    private Ellipse ellipse;
    @FXML
    private Group point;
    @FXML
    private Label pointCoorinates;
    @FXML
    private Label ellipseCoordinates;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setClickedPoint(double x, double y) {
        clicked.setX(x);
        clicked.setY(y);

        point.setLayoutX(x);
        point.setLayoutY(y);
    }

    public Point getClickedPoint() {
        return new Point(clicked.getX(), clicked.getY());
    }

    public void setEllipsePosition(Point p) {
        ellipse.setCenterX(p.getX());
        ellipse.setCenterY(p.getY());
    }

    public Point getEllipsePosition() {
        return new Point(ellipse.getCenterX(), ellipse.getCenterY());
    }

    public void setPointLabelText(Point point) {
        pointCoorinates.setText("Clicked Point X: " + point.getX()
                + "  Y: " + point.getY());
    }

    public void setEllipseLabelText(Point point) {
        ellipseCoordinates.setText("Ellipse X: " + decimal.format(point.getX())
                + "  Y: " + decimal.format(point.getY()));
    }

    @FXML
    private void handleMouseClickedAction(MouseEvent event) {
        clickCounter++;
        setClickedPoint(event.getX(), event.getY());
        setPointLabelText(clicked);

        if (clickCounter >= 2) {
            ellipse.setFill(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            clickCounter = 0;
        }
        if (!threadRunning) {
            //Start thread
            moveEllipse = new EllipseEngine(this);
            engine = new Thread(moveEllipse);
            engine.setDaemon(true);
            engine.start();

            threadRunning = true;
        } else {
            //Kill running thread
            moveEllipse.cancel();
            engine = null;

            //Start a new thread
            moveEllipse = new EllipseEngine(this);
            engine = new Thread(moveEllipse);
            engine.setDaemon(true);
            engine.start();
        }
    }
}
