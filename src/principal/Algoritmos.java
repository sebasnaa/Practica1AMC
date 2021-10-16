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

    public static void ordenarQuick(Punto[] puntos) {
        ordenarQuick(puntos, 0, puntos.length - 1);
    }

    private static void ordenarQuick(Punto[] puntos, int izquierda, int derecha) {

        if (derecha - izquierda <= 0) {
            return;
        }

        double pivote = puntos[(izquierda + derecha) / 2].getX();

        int i = izquierda;
        int j = derecha;
        Punto aux;

        while (i <= j) {
            while (puntos[i].getX() < pivote) {
                i++;
            }
            while (puntos[j].getX() > pivote) {
                j--;
            }
            if (i <= j) {
                aux = puntos[i];
                puntos[i] = puntos[j];
                puntos[j] = aux;
                i++;
                j--;
            }
        }
        ordenarQuick(puntos, izquierda, i - 1);
        ordenarQuick(puntos, i, derecha);
    }

    public static Triangulo DyV(Punto[] puntos) {
        return DyV(puntos, 0, puntos.length - 1);
    }

    private static Triangulo DyV(Punto[] puntos, int izquierda, int derecha) {

        if ((derecha - izquierda + 1) <= 4) {
            return busquedaExhaustiva(puntos);
        }

        Triangulo Ti, Td;
        //numero de elementos, si son pocos(<=4), aplicamos exhaustivo
        int n = derecha - izquierda + 1;
        int Xm = (derecha + izquierda) / 2;

        int capI = (Xm - izquierda + 1);
        int capD = (derecha - Xm);

        

        Punto[] puntosIzq = new Punto[n];//Xm - izquierda + 1];
        Punto[] puntosDer = new Punto[n];//n - (Xm - izquierda + 1)];

        System.out.println(puntos[Xm].getX());

        //Obtenemos las listas de las mitades para buscar en cada una el mejor caso
        int pi = 0, pd = 0;
        for (int i = 0; i < puntos.length; i++) {
            //pertenece a zona izquierda
            if (pi < puntosIzq.length && (puntos[i].getX() < puntos[Xm].getX())) {
                puntosIzq[pi++] = puntos[i];
            } else {
                puntosDer[pd++] = puntos[i];
            }
        }

        Ti = DyV(puntosIzq, izquierda, Xm);
        Td = DyV(puntosDer, Xm + 1, derecha);

        //Se guarda el triangulo menor en Tmin
        Triangulo Tmin = Ti.comparar(Td);

        //Ahora sobre la zona comun en base a la distancia minima se hace la busqueda y se almacenan solo los puntos que estan dentro del rango
        //del perimetro menor
        Punto[] zonaComun = new Punto[n];
        int numeroComunes = 0;

        for (int i = 0; i < puntos.length; i++) {
            if (Math.abs(puntos[i].getX() - puntos[Xm].getX()) < Tmin.perimetro()) {
                zonaComun[numeroComunes++] = puntos[i];
            }
        }

        n = numeroComunes;
        //puntos = zonaComun;
        Punto valores[] = zonaComun;
        Triangulo aux;

        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((valores[j].getX() - valores[i].getX()) < Tmin.perimetro()) {

                    for (int k = j + 1; k <= n; k++) {

                        if ((valores[k].getX() - valores[j].getX()) < Tmin.perimetro()) {
                            aux = new Triangulo(valores[i], valores[j], valores[k]);
                            //Se comparan y el menor se almacena en trianguloMenor
                            Tmin = aux.comparar(Tmin);
                        }
                    }
                }
            }
        }

        return Tmin;

    }

}
