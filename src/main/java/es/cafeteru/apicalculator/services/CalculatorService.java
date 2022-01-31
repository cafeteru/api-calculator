package es.cafeteru.apicalculator.services;

import java.math.BigDecimal;

import es.cafeteru.apicalculator.model.Operacion;

public interface CalculatorService {
    BigDecimal suma(Operacion sumando1, Operacion sumando2);

    BigDecimal resta(Operacion minuendo, Operacion sustraendo);
}
