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
import static modelo.OperacionesPila.*;
import datos.Productos;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author jose.escobar
 */
public class FXMLDocumentController implements Initializable {
    
    Pila<Productos> pilaP;
    @FXML
    private Label label;
    
    @FXML
    private WebView webView;
    WebEngine webEngine;
    
    
    public String organizar(Pila<Productos> laPila){
        String res = "";
        while(!laPila.estaVacia()){
            Productos elemento = laPila.desapilar();
            res  += "<tr>" + "<td>" + elemento.getNombre() + "<td>" + "<td>" + elemento.getCantidad() + "<td>" + "<td>" + elemento.getValor() + "<td>"  + "<td>"+ "</tr>";
        }
        return res;
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Productos elemento = new Productos("Pitaya", 1, 20000);
        pilaP.apilar(elemento);
        Pila<Productos> pilaD = pilaDuplicada(pilaP);
        String p = "<html>"+
                        "<head>" +
                            "<title> a </title>" +
                            "<meta charset='UTF-8'>" +
                        "</head>" +
                        "<table>" + 
                            "<tr>" +
                                "<td>" + "Nombre" + "<td>"+
                                "<td>" + "Cantidad" + "<td>"+
                                "<td>" + "Precio" + "<td>"+ "</tr>"+
                                organizar(pilaD) +
                        "</table>"+
                    "</html>";
        
        webEngine.loadContent(p);
        
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pilaP = new Pila<>();
        webEngine = webView.getEngine();
    }    
    
}
