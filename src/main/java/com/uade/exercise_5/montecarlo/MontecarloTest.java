package com.uade.exercise_5.montecarlo;

import org.junit.Test;

import java.util.Random;

public class MontecarloTest {
    
    @Test
    public void test(){
        double ladoCuadrado = 4.0;
        Montecarlo montecarlo = new Montecarlo(ladoCuadrado);

        Random random = new Random();
        int numeroDeCoordenadas = 1000;

        for (int i = 0; i < numeroDeCoordenadas; i++) {
            double x = random.nextDouble() * ladoCuadrado;
            double y = random.nextDouble() * ladoCuadrado;
            Coordenada coordenada = new Coordenada(x, y);
            montecarlo.agregarCoordenada(coordenada);
        }

        double piAproximado = montecarlo.aproximarPi();
        System.out.println("Aproximación de π: " + piAproximado);
    }

}
