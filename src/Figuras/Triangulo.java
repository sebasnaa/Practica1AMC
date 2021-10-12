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
public class Triangulo {

    private final Punto pa, pb, pc;
    private Double perimetro;
    
    public Triangulo(Punto a, Punto b, Punto c) {
        this.pa = a;
        this.pb = b;
        this.pc = c;
        this.perimetro = null;
    }
    
    public double perimetro(){
        this.perimetro = pa.distancia(pb) + pb.distancia(pc) + pc.distancia(pa);
        
        return perimetro;
    }

    //En base a las distancias entres los tres vertices calculamos el 
    //camino mas corto, variando el Punto en comun
    public Punto minimaDistanciaPuntoComun() {
        double distAbAc, distBaBc, distCaCb;
        Punto res = this.pa;
        
        distAbAc = pa.distancia(pb) + pa.distancia(pc);
        distBaBc = pb.distancia(pa) + pb.distancia(pc);
        distCaCb = pc.distancia(pa) + pc.distancia(pb);
        
        if(distBaBc < distAbAc){
            res = this.pb;
            if(distCaCb < distBaBc){
                res = this.pc;
            }
        }
        if(distCaCb < distAbAc){
            res = this.pc;
        }
        
        
     return res;   
    }
    
    public Triangulo comparar(Triangulo t){
        
        if(t.perimetro() < perimetro())
            return t;
        else
            return this;
    }
    
    @Override
    public String toString(){
        return "" + pa.toString() + pb.toString() + pc.toString();
    }

}
