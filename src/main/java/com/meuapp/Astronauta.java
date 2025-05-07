package com.meuapp;

public class Astronauta {
    public static boolean autoriza(float peso, float altura, float tempoEscadas) {
        if (peso < 50 || peso > 101) {
            throw new IllegalArgumentException("Peso fora dos limites permitidos.");
        }
        if (altura < 1.52 || altura > 1.93) {
            throw new IllegalArgumentException("Altura fora dos limites permitidos.");
        }
        if (tempoEscadas >= 80) {
            throw new IllegalArgumentException("Tempo para subir escadas excedido.");
        }
        return true;
    }
}
