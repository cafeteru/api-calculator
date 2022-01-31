package es.cafeteru.apicalculator.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Numero implements Operacion {
    private BigDecimal valor;

    @Override
    public BigDecimal ejecutar() {
        return valor;
    }
}
