package com.calc;

import org.w3c.dom.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonBorrarTodo;

    @FXML
    private Button buttonBorrar1;

    @FXML
    private Button buttonParentesisDerecho;

    @FXML
    private Button buttonParentesisIzquierdo;

    @FXML
    private Button buttonMas;

    @FXML
    private Button buttonMulti;

    @FXML
    private Button buttonDivision;

    @FXML
    private Button buttonMenos;

    @FXML
    private Button buttonComa;

    @FXML
    private Text Texto0;

    @FXML
    private StringBuilder input = new StringBuilder(); // Variable para almacenar la entrada del usuario

    @FXML
    private void Numeros(ActionEvent e) {
        Button sourceButton = (Button) e.getSource();
        String buttonText = sourceButton.getText();   

        input.append(buttonText); 
        Texto0.setTextContent(input.toString()); 
    }

    @FXML
    private void borrarTodo(ActionEvent e) {
        input.setLength(0); 
        Texto0.setTextContent(""); 
    }
}
