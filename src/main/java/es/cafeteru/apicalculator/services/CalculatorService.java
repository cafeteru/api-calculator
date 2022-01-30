package es.cafeteru.apicalculator.services;

import java.math.BigDecimal;

public interface CalculatorService {
    BigDecimal suma(BigDecimal sumando1, BigDecimal sumando2);

    BigDecimal resta(BigDecimal sumando1, BigDecimal sumando2);
}
