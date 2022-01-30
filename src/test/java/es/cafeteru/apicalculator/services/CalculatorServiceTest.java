package es.cafeteru.apicalculator.services;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cafeteru.apicalculator.services.impl.CalculatorServiceImpl;
import lombok.var;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void initTest() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void suma_con_valores_positivos() {
        var resultado = calculatorService.suma(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        Assertions.assertEquals(BigDecimal.valueOf(5), resultado);
    }

    @Test
    void suma_con_valores_negativos() {
        var resultado = calculatorService.suma(BigDecimal.valueOf(-2), BigDecimal.valueOf(-3));
        Assertions.assertEquals(BigDecimal.valueOf(-5), resultado);
    }

    @Test
    void suma_con_valor_positivo_y_negativo() {
        var resultado = calculatorService.suma(BigDecimal.valueOf(2), BigDecimal.valueOf(-3));
        Assertions.assertEquals(BigDecimal.valueOf(-1), resultado);
        resultado = calculatorService.suma(BigDecimal.valueOf(-2), BigDecimal.valueOf(3));
        Assertions.assertEquals(BigDecimal.valueOf(1), resultado);
    }

    @Test
    void resta_con_valores_positivos() {
        var resultado = calculatorService.resta(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        Assertions.assertEquals(BigDecimal.valueOf(-1), resultado);
    }

    @Test
    void resta_con_valores_negativos() {
        var resultado = calculatorService.resta(BigDecimal.valueOf(-2), BigDecimal.valueOf(-3));
        Assertions.assertEquals(BigDecimal.valueOf(1), resultado);
    }

    @Test
    void resta_con_valor_positivo_y_negativo() {
        var resultado = calculatorService.resta(BigDecimal.valueOf(2), BigDecimal.valueOf(-3));
        Assertions.assertEquals(BigDecimal.valueOf(5), resultado);
        resultado = calculatorService.resta(BigDecimal.valueOf(-2), BigDecimal.valueOf(3));
        Assertions.assertEquals(BigDecimal.valueOf(-5), resultado);
    }
}
