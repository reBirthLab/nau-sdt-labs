/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab6;

import static java.lang.Math.cos;
import static java.lang.Math.exp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class FunctionBuilderGUIController implements Initializable {

    @FXML
    private ScrollPane pane;
    @FXML
    private Polyline polyline0;
    @FXML
    private Polyline polyline1;
    @FXML
    private Polyline polyline2;
    @FXML
    private Slider sliderX;
    @FXML
    private Slider sliderY;
    @FXML
    private MenuItem menuBuild;
    @FXML
    private MenuItem menuReset;
    @FXML
    private MenuItem menuDefault;
    @FXML
    private TextField xMinInput;
    @FXML
    private TextField xMaxInput;
    @FXML
    private TextField formulaInput1;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonLabel = button.getText();
        switch (buttonLabel) {
            case "Build":
                drawGraphs();
                break;
            case "Reset":
                clearGraphs();
                break;
            case "Default":
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drawGraphs();
    }

    private void drawGraphs() {
        clearGraphs();

        Double x, y;
        Double xMin = Double.parseDouble(xMinInput.getText());
        Double xMax = Double.parseDouble(xMaxInput.getText());

//        int scaleX = (int) (pane.getPrefWidth() / xMax);
//        int scaleY = (int) (pane.getPrefHeight() / 20);
//        
//        for (x = xMin; x < xMax; x += 0.05) {
//            
//            y = 10 * exp(-x / 4) * cos(3 * x);
//            polyline0.getPoints().addAll(x * scaleX, -y * scaleY);
//            
//            y = 10 * exp(-x / 4);
//            polyline1.getPoints().addAll(x * scaleX, -y * scaleY);
//            
//            y = -10 * exp(-x / 4);
//            polyline2.getPoints().addAll(x * scaleX, -y * scaleY);
//        }
        int scaleX = (int) sliderX.getValue();
        int scaleY = (int) sliderY.getValue();

        // Interpeter bsh = new Interpreter();
        // double dd = bsh.eval(formulaInput1.getText());
        for (x = xMin; x < xMax; x += 0.05) {

            y = 10 * exp(-x / 4) * cos(3 * x);
            polyline0.getPoints().addAll(x * scaleX, -y * scaleY);

            y = 10 * exp(-x / 4);
            polyline1.getPoints().addAll(x * scaleX, -y * scaleY);

            y = -10 * exp(-x / 4);
            polyline2.getPoints().addAll(x * scaleX, -y * scaleY);
        }
    }

    private void clearGraphs() {
        polyline0.getPoints().clear();
        polyline1.getPoints().clear();
        polyline2.getPoints().clear();
    }

    @FXML
    private void handleSliderAction(MouseEvent event) {
        drawGraphs();
    }

    @FXML
    private void handleMenuActions(ActionEvent event) {
    }

}
