package es.cafeteru.apicalculator.services;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cafeteru.apicalculator.services.impl.CalculatorServiceImpl;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void initTest() {
        calculatorService = new CalculatorServiceImpl();
    }
    
    @Test
    void suma_con_valores() {
        BigDecimal resultado = calculatorService.suma(BigDecimal.ONE, BigDecimal.ONE);
        Assertions.assertEquals(BigDecimal.ZERO, resultado);
    }
}
