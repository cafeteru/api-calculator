package es.cafeteru.apicalculator.services;

import java.math.BigDecimal;

import es.cafeteru.apicalculator.model.Operacion;

public interface CalculatorService {
    BigDecimal identificaOperador(Operacion op1, Operacion op2, String operador);
}
