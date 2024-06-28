package com.uade.exercise_5.montecarlo;

public class Coordenada {
    private final double x;
    private final double y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanciaAlOrigen() {
        return Math.sqrt(x * x + y * y);
    }

    // Método para calcular la distancia entre esta coordenada y otra
    public double distanciaA(Coordenada otra) {
        double dx = this.x - otra.x;
        double dy = this.y - otra.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}