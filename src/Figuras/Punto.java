/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author sebas
 */
public class Punto {

    public final double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto(String x, String y) {
        this.x = Double.parseDouble(x);
        this.y = Double.parseDouble(y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distancia(Punto pp) {
        return Math.sqrt(Math.pow(x - pp.x, 2) + Math.pow(y - pp.y, 2));
    }

    public static double distancia2(Punto a, Punto b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
    
    public String toString(){
        return ""+ this.getX() + "  " + this.getY();
    }

}
