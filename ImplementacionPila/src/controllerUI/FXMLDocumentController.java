/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelo.Pila;
import datos.Productos;
import static modelo.Tools.*;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author jose.escobar
 */
public class FXMLDocumentController implements Initializable {
    
    Pila<Productos> pilaP;
    @FXML
    private Label label, label1, label2, label3, label4;
    
    @FXML
    private TextField textF, textF1, textF2;
    
    @FXML
    private WebView webView;
    WebEngine webEngine;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
            String nombre = textF.getText();
            int cantidad = Integer.parseInt(textF1.getText());
            double valor = Double.parseDouble(textF2.getText());
            Productos elemento = new Productos(nombre, cantidad, valor);
            pilaP.apilar(elemento);
            webEngine.loadContent(crearHTML(pilaP));
            label4.setText(""); 
            textF.setText("");
            textF1.setText("");
            textF2.setText("");
        }catch (Exception e){
            label4.setText("Error en los datos numericos");
        }
                
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pilaP = new Pila<>();
        webEngine = webView.getEngine();
        webView.zoomProperty().set(0.5);
    }    
    
}
