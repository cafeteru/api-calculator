package es.cafeteru.apicalculator.controllers;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

    private CalculatorController calculatorController;

    @BeforeEach
    void initTest() {
        calculatorController = new CalculatorController();
    }

    @Test
    void suma_con_valores() {
        BigDecimal resultado = calculatorController.suma(BigDecimal.ONE, BigDecimal.ONE).getBody();
        Assertions.assertEquals(BigDecimal.ZERO, resultado);
    }
}
