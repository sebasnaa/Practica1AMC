/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Figuras.Punto;
import java.io.IOException;

/**
 *
 * @author sebas
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Punto puntos[];

        //puntos = TSP.lecturaTSP("datos/berlin52.tsp");
        puntos = TSP.lecturaTSP("datos/ch150.tsp");

        for (Punto p : puntos) {
            System.out.println(p);
        }
    }

}
