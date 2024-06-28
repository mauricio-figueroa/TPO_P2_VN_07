package com.uade.exercise_5.montecarlo;

import java.util.ArrayList;

public class Montecarlo {
    private final ArrayList<Coordenada> coordenadas;
    private final Coordenada centroDelCirculo;
    private final double ladoCuadrado;

    public Montecarlo(double ladoCuadrado) {
        this.ladoCuadrado = ladoCuadrado;
        this.coordenadas = new ArrayList<>();
        this.centroDelCirculo = new Coordenada(ladoCuadrado / 2, ladoCuadrado / 2);
    }

    public void agregarCoordenada(Coordenada c) {
        if (c.getX() <= ladoCuadrado && c.getY() <= ladoCuadrado) {
            coordenadas.add(c);
        }
    }

    public double aproximarPi() {
        double dentroDelCirculo = 0;
        double radio = ladoCuadrado / 2;
        for (Coordenada c : coordenadas) {
            if (centroDelCirculo.distanciaA(c) < radio) {
                dentroDelCirculo++;
            }
        }
        double areaDelCuadrado = Math.pow(ladoCuadrado,ladoCuadrado);
        //puntos dentro del circulo/puntos totales
        double ratio = (dentroDelCirculo / coordenadas.size());
        return 4.0D *  ratio;
    }
}
