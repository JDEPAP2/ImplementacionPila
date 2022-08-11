/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import static modelo.OperacionesPila.*;
import datos.Productos;
/**
 *
 * @author PC
 */
public class Tools {
    public static String organizar(Pila<Productos> laPila){
        String res = "";
        while(!laPila.estaVacia()){
            Productos elemento = laPila.desapilar();
            res  += "<tr>" + "<td>" + elemento.getNombre() + "<td>" 
                    + "<td style='text-align: center;'>" + elemento.getCantidad() + "<td>" 
                    + "<td style='text-align: left;'>" + elemento.getValor() + "<td>"+ "</tr>";
        }
        return res;
    }
    public static String crearHTML(Pila<Productos> laPila){
        Pila<Productos> pilaD = pilaDuplicada(laPila);
        String p = "<html style=\"padding: 2em;\">";
//        if (laPila.estaVacia()){
//            p += "<h1 style='font-family: sans-serif; color: #2a9adb;' > La pila esta vacia </h1>";
//        }else{            
            p += "<h1 style='font-family: sans-serif; color: #2a9adb;'>Pila de Productos<h1>" +
                "<table class=\"styled-table\">" +
                "<thead>" +
                    "<tr>" +
                        "<td>" + "Nombre" + "<td>"+
                        "<td>" + "Cantidad" + "<td>"+
                        "<td>" + "Precio" + "<td>"+ 
                    "</tr>"+
                "</thead>" +
                    organizar(pilaD) +
            "</table>"+
            "<style>.styled-table {border-collapse: collapse;margin: 25px 0;font-size: 0.9em;font-family: sans-serif;min-width: 400px;border-radius: 5px 5px 0 0;box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);overflow: hidden;}.styled-table thead tr {background-color: #2a9adb;color: #ffffff;text-align: left;}.styled-table th,.styled-table td {padding: 12px 15px;}.styled-table tbody tr {border-bottom: 1px solid #dddddd;}.styled-table tbody tr:nth-of-type(even) {background-color: #f3f3f3;}.styled-table tbody tr:last-of-type {border-bottom: 2px solid #2a9adb;}</style>";                       
//        }
        p += "</html>";
        return p;
    }
}
