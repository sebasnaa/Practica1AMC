/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;


import static principal.Algoritmos.*;
import Figuras.Punto;
import Figuras.Triangulo;
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

        int n = 1000;
        int minimo = 1;
        int maximo = 10000;
        Punto puntos[] = new Punto[n];

        //puntos = TSP.lecturaTSP("datos/berlin52.tsp");
        //puntos = TSP.lecturaTSP("datos/ch150.tsp");
        //puntos = TSP.lecturaTSP("datos/d493.tsp");
        
        for(int i = 0;i<n;i++){
            puntos[i] = new Punto(  Math.random() * ((maximo - minimo)+1) + minimo , Math.random() * ((maximo - minimo)+1) + minimo);
        }

        Triangulo a = busquedaExhaustiva(puntos);
        Punto puntoComun = a.minimaDistanciaPuntoComun();

        System.out.println(a);
        System.out.println(puntoComun);

    }

}
