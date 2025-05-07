package com.meuapp;

import net.jqwik.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AstronautaTest {
    static class Candidato{
        float altura;
        float peso;
        float tempoEscadas;

        public Candidato(float altura, float peso, float tempoEscadas){
            this.altura = altura;
            this.peso = peso;
            this.tempoEscadas = tempoEscadas;
        }

        @Override
        public String toString(){
            return "Candidato [altura=" + altura ", peso=" + peso "]";
        }
    }

    // Teste com valores válidos (deve retornar true)
    @Property
    void testeAprovadoPorEscada(
        @ForAll Candidato c
    ) {
        var resultado = Astronauta.autoriza(c.peso, c.altura, c.tempoEscadas);
        assertTrue(resultado);
    }

    // Testes com valores inválidos (devem lançar IllegalArgumentException)
    @Property
    void rejeitaPesoInvalido(
        @ForAll("pesoInvalido") float peso,
        @ForAll @FloatRange(min = 1.52f, max = 1.93f) float altura,
        @ForAll @FloatRange(min = 0.0f, max = 79.999f) float tempoEscadas
    ) {
        assertThrows(IllegalArgumentException.class, () -> Astronauta.autoriza(peso, altura, tempoEscadas));
    }

    @Provide
    Arbitrary<Float> pesoInvalido() {
        return Arbitraries.floats().lessThan(50f).or(Arbitraries.floats().greaterThan(101f));
    }

    @Property
    void rejeitaAlturaInvalida(
        @ForAll @FloatRange(min = 50f, max = 101f) float peso,
        @ForAll("alturaInvalida") float altura,
        @ForAll @FloatRange(min = 0.0f, max = 79.999f) float tempoEscadas
    ) {
        assertThrows(IllegalArgumentException.class, () -> Astronauta.autoriza(peso, altura, tempoEscadas));
    }

    @Provide
    Arbitrary<Float> alturaInvalida() {
        return Arbitraries.floats().lessThan(1.52f).or(Arbitraries.floats().greaterThan(1.93f));
    }

    @Property
    void rejeitaTempoInvalido(
        @ForAll @FloatRange(min = 50f, max = 101f) float peso,
        @ForAll @FloatRange(min = 1.52f, max = 1.93f) float altura,
        @ForAll @FloatRange(min = 80.0f, max = 200.0f) float tempoEscadas
    ) {
        assertThrows(IllegalArgumentException.class, () -> Astronauta.autoriza(peso, altura, tempoEscadas));
    }
}
