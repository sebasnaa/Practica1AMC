/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Figuras.Punto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author sebas
 */
public class TSP {

    //Clase para lectura de archivos extension tsp
    public static Punto[] lecturaTSP(String archivo) throws FileNotFoundException, IOException {
        Punto puntos[] = null;
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        boolean encontrado = false;
        String linea;
        int k = 0;

        while ((linea = lector.readLine()) != null) {

            if(!linea.equals("EOF") && !linea.equals("")){
                //System.out.println(linea);
                if (linea.contains("DIMENSION")) {
                    String partes[] = linea.split(":");
                    //System.out.println(partes[1]);
                    puntos = new Punto[Integer.parseInt(partes[1].trim())];
                }

                if (encontrado) {
                    String partes[] = linea.split(" ");
                    puntos[k] = new Punto(Double.parseDouble(partes[1].trim()), Double.parseDouble(partes[2].trim()));
                    k++;
                } else {
                    if (linea.equals("NODE_COORD_SECTION")) {
                        encontrado = true;
                    }
                }
            }
            
            
            

        }
        

        return puntos;
    }

}
