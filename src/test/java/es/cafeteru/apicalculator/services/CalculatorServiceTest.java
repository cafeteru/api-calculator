package es.cafeteru.apicalculator.services;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cafeteru.apicalculator.model.Numero;
import es.cafeteru.apicalculator.model.Operacion;
import es.cafeteru.apicalculator.services.impl.CalculatorServiceImpl;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void initTest() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void suma_con_valores_positivos() {
        Operacion op1 = new Numero(BigDecimal.valueOf(2));
        Operacion op2 = new Numero(BigDecimal.valueOf(3));
        BigDecimal resultado = calculatorService.identificaOperador(op1, op2, "+");
        Assertions.assertEquals(BigDecimal.valueOf(5), resultado);
    }

    @Test
    void suma_con_valores_negativos() {
        Operacion op1 = new Numero(BigDecimal.valueOf(-2));
        Operacion op2 = new Numero(BigDecimal.valueOf(-3));
        BigDecimal resultado = calculatorService.identificaOperador(op1, op2, "+");
        Assertions.assertEquals(BigDecimal.valueOf(-5), resultado);
    }

    @Test
    void suma_con_valor_positivo_y_negativo() {
        Operacion op1 = new Numero(BigDecimal.valueOf(2));
        Operacion op2 = new Numero(BigDecimal.valueOf(-3));
        BigDecimal resultado = calculatorService.identificaOperador(op1, op2, "+");
        Assertions.assertEquals(BigDecimal.valueOf(-1), resultado);
        op1 = new Numero(BigDecimal.valueOf(-2));
        op2 = new Numero(BigDecimal.valueOf(3));
        resultado = calculatorService.identificaOperador(op1, op2, "+");
        Assertions.assertEquals(BigDecimal.valueOf(1), resultado);
    }

    @Test
    void resta_con_valores_positivos() {
        Operacion op1 = new Numero(BigDecimal.valueOf(2));
        Operacion op2 = new Numero(BigDecimal.valueOf(3));
        BigDecimal resultado = calculatorService.identificaOperador(op1, op2, "-");
        Assertions.assertEquals(BigDecimal.valueOf(-1), resultado);
    }

    @Test
    void resta_con_valores_negativos() {
        Operacion op1 = new Numero(BigDecimal.valueOf(-2));
        Operacion op2 = new Numero(BigDecimal.valueOf(-3));
        BigDecimal resultado = calculatorService.identificaOperador(op1, op2, "-");
        Assertions.assertEquals(BigDecimal.valueOf(1), resultado);
    }

    @Test
    void resta_con_valor_positivo_y_negativo() {
        Operacion op1 = new Numero(BigDecimal.valueOf(2));
        Operacion op2 = new Numero(BigDecimal.valueOf(-3));
        BigDecimal resultado = calculatorService.identificaOperador(op1, op2, "-");
        Assertions.assertEquals(BigDecimal.valueOf(5), resultado);
        op1 = new Numero(BigDecimal.valueOf(-2));
        op2 = new Numero(BigDecimal.valueOf(3));
        resultado = calculatorService.identificaOperador(op1, op2, "-");
        Assertions.assertEquals(BigDecimal.valueOf(-5), resultado);
    }

    @Test
    void operador_no_definido() {
        Operacion op1 = new Numero(BigDecimal.valueOf(2));
        Operacion op2 = new Numero(BigDecimal.valueOf(3));
        try {
            calculatorService.identificaOperador(op1, op2, "$");
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            Assertions.assertNotNull(e);
        }
    }
}
