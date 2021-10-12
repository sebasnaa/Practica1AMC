package principal;

import Figuras.Punto;
import Figuras.Triangulo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sebas
 */
public class Algoritmos {

    public static Triangulo busquedaExhaustiva(Punto[] puntos) {
        return busquedaExhaustiva(puntos, 0, puntos.length - 1);
    }

    private static Triangulo busquedaExhaustiva(Punto[] puntos, int ini, int fin) {
        Triangulo trianguloMenor = new Triangulo(puntos[0], puntos[1], puntos[2]);
        Triangulo aux;

        for (int i = ini; i <= fin; i++) {
            for (int j = i + 1; j <= fin; j++) {
                for (int k = j + 1; k <= fin; k++) {
                    aux = new Triangulo(puntos[i], puntos[j], puntos[k]);
                    //Se comparan y el menor se almacena en trianguloMenor
                    trianguloMenor = aux.comparar(trianguloMenor);
                }
            }
        }
        return trianguloMenor;
    }

}
