/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab8;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class PursuerGUIController implements Initializable {

    @FXML
    private static Pane pane;
    @FXML
    private Ellipse ellipse;
    
    private Thread engine;
    private EllipseEngine moveEllipse;
    private  Point ellipsePosition;
    private  Point clicked = new Point(0.0, 0.0);
    private boolean threadRunning = false;
    private Random rand = new Random();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void setClickedPoint(double x, double y) {
        clicked.x = x;
        clicked.y = y;
    }
    
    public Point getClickedPoint() {
        return new Point(clicked.x, clicked.y);
    }
    
    public void setEllipsePosition(Point p) {
        ellipse.setCenterX(p.x);
        ellipse.setCenterY(p.y);
    }
    
    public Point getEllipsePosition() {
        return new Point(ellipse.getCenterX(), ellipse.getCenterY());
    }

    @FXML
    private void handleMouseClickedAction(MouseEvent event) {
        setClickedPoint(event.getX(), event.getY());
        ellipse.setFill(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        
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
