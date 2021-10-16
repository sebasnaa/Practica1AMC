/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import static principal.Algoritmos.*;
import Figuras.Punto;
import Figuras.Triangulo;
import java.awt.BorderLayout;
import java.io.IOException;

/**
 *
 * @author sebas
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        int n = 5;
        int minimo = 1;
        int maximo = 10;

        Punto puntos[] = new Punto[n];

        for (int i = 0; i < n; i++) {
            puntos[i] = new Punto(  Math.random() * ((maximo - minimo)+1) + minimo , Math.random() * ((maximo - minimo)+1) + minimo);
        }

        //puntos = TSP.lecturaTSP("datos/berlin52.tsp");
        //puntos = TSP.lecturaTSP("datos/ch150.tsp");
        //puntos = TSP.lecturaTSP("datos/d493.tsp");
        
        Triangulo aa = DyV(puntos);
        
        System.out.println(aa);
        
        

        //ordenarQuick(puntos);
//        for ( Punto p : puntos){
//            System.out.println(p);
//        }
//        Triangulo a = busquedaExhaustiva(puntos);
//        System.out.println(a);
//        Punto puntoComun = a.minimaDistanciaPuntoComun();
    }

}
