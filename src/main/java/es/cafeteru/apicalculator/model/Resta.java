package es.cafeteru.apicalculator.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Resta implements Operacion {
    private Operacion operacion1;
    private Operacion operacion2;

    @Override
    public BigDecimal ejecutar() {
        return operacion1.ejecutar().subtract(operacion2.ejecutar());
    }
}
