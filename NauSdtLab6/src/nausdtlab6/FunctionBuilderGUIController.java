/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab6;

import static java.lang.Math.cos;
import static java.lang.Math.exp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;
import javafx.stage.StageStyle;
import org.mdkt.compiler.InMemoryJavaCompiler;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class FunctionBuilderGUIController implements Initializable {

    @FXML
    private ScrollPane pane;
    @FXML
    private Polyline polyline1;
    @FXML
    private Polyline polyline2;
    @FXML
    private Polyline polyline3;
    @FXML
    private Slider sliderX;
    @FXML
    private Slider sliderY;
    @FXML
    private TextField xMinInput;
    @FXML
    private TextField xMaxInput;
    @FXML
    private TextField formulaInput1;
    @FXML
    private TextField formulaInput2;
    @FXML
    private TextField formulaInput3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            drawGraphs();
        } catch (Exception ex) {
            Logger.getLogger(FunctionBuilderGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Class<?> dynamicFunction(String formula) throws Exception {

        String sourceCode = "package nausdtlab6.runtime;"
                + "import static java.lang.Math.*;"
                + "public class Function {"
                + "public double func(java.lang.Double x){"
                + "return " + formula + ";"
                + "}"
                + "}";

        return InMemoryJavaCompiler.compile("nausdtlab6.runtime.Function", sourceCode);
    }

    private double function(double x, Class<?> functionClass) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Object newFunction = functionClass.newInstance();
        Method method = functionClass.getDeclaredMethod("func", Double.class);
        return (double) method.invoke(newFunction, x);
    }

    private void drawGraphs() throws Exception {
        clearGraphs();

        Double x, y;
        Double xMin = Double.parseDouble(xMinInput.getText());
        Double xMax = Double.parseDouble(xMaxInput.getText());

        int scaleX = (int) sliderX.getValue();
        int scaleY = (int) sliderY.getValue();

        String formula1, formula2, formula3;

        if (!"".equals(formulaInput1.getText())) {
            formula1 = formulaInput1.getText();
            polyline1.setVisible(true);
        } else {
            formula1 = "0";
            polyline1.setVisible(false);
        }

        if (!"".equals(formulaInput2.getText())) {
            formula2 = formulaInput2.getText();
            polyline2.setVisible(true);
        } else {
            formula2 = "0";
            polyline2.setVisible(false);
        }

        if (!"".equals(formulaInput3.getText())) {
            formula3 = formulaInput3.getText();
            polyline3.setVisible(true);
        } else {
            formula3 = "0";
            polyline3.setVisible(false);
        }

        Class func1 = dynamicFunction(formula1);
        Class func2 = dynamicFunction(formula2);
        Class func3 = dynamicFunction(formula3);

        for (x = xMin; x < xMax; x += 0.05) {

            y = function(x, func1);
            polyline1.getPoints().addAll(x * scaleX, -y * scaleY);

            y = function(x, func2);
            polyline2.getPoints().addAll(x * scaleX, -y * scaleY);

            y = function(x, func3);
            polyline3.getPoints().addAll(x * scaleX, -y * scaleY);
        }
    }

    private void drawDefaultGraphs() {
        //FIRST SIMPLE VERSION
        clearGraphs();

        formulaInput1.setText("10*exp(-x/4) * cos(3*x)");
        formulaInput2.setText("10*exp(-x/4)");
        formulaInput3.setText("-10*exp(-x/4)");
        
        polyline1.setVisible(true);
        polyline2.setVisible(true);
        polyline3.setVisible(true);

        Double x, y;
        Double xMin = Double.parseDouble(xMinInput.getText());
        Double xMax = Double.parseDouble(xMaxInput.getText());

        int scaleX = (int) (pane.getPrefWidth() / xMax);
        int scaleY = (int) (pane.getPrefHeight() / 20);

        for (x = xMin; x < xMax; x += 0.05) {

            y = 10 * exp(-x / 4) * cos(3 * x);
            polyline1.getPoints().addAll(x * scaleX, -y * scaleY);

            y = 10 * exp(-x / 4);
            polyline2.getPoints().addAll(x * scaleX, -y * scaleY);

            y = -10 * exp(-x / 4);
            polyline3.getPoints().addAll(x * scaleX, -y * scaleY);
        }
    }

    private void clearGraphs() {
        polyline1.getPoints().clear();
        polyline2.getPoints().clear();
        polyline3.getPoints().clear();
    }

    private void resetInputFields() {
        formulaInput1.setText("");
        formulaInput2.setText("");
        formulaInput3.setText("");
    }

    private void showAbout() {
        Alert aboutPopup = new Alert(Alert.AlertType.INFORMATION);
        aboutPopup.setTitle("About");
        aboutPopup.setHeaderText(null);
        aboutPopup.initStyle(StageStyle.UTILITY);
        aboutPopup.setContentText("MATH GRAPHS BUILDER 1.0\n"
                + "by Anastasiy Tostik\n\n"
                + "This is a simple app written in Java that can visualise three "
                + "mathematical functions at the same time.\n\n"
                + "Have FUN!");

        aboutPopup.showAndWait();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        String buttonLabel = button.getText();
        switch (buttonLabel) {
            case "Build":
                drawGraphs();
                break;
            case "Reset":
                resetInputFields();
                clearGraphs();
                break;
            case "Default":
                drawDefaultGraphs();
                break;
        }
    }

    @FXML
    private void handleSliderAction(MouseEvent event) throws Exception {
        drawGraphs();
    }

    @FXML
    private void handleMenuActions(ActionEvent event) throws Exception {
        MenuItem mItem = (MenuItem) event.getSource();
        String action = mItem.getText();
        switch (action) {
            case "Build":
                drawGraphs();
                break;
            case "Reset":
                resetInputFields();
                clearGraphs();
                break;
            case "Default":
                drawDefaultGraphs();
                break;
            case "About":
                showAbout();
                break;
        }
    }

}
