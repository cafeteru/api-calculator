package es.cafeteru.apicalculator.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import es.cafeteru.apicalculator.services.CalculatorService;
import lombok.var;

class CalculatorControllerTest {

    private CalculatorController calculatorController;
    private CalculatorService calculatorService;

    @BeforeEach
    void initTest() {
        calculatorService = mock(CalculatorService.class);
        calculatorController = new CalculatorController(calculatorService);
    }

    @Test
    void suma_con_valores_positivos() {
        var mockResultado = BigDecimal.valueOf(5);
        when(calculatorService.suma(any(), any())).thenReturn(mockResultado);
        var responseEntity = calculatorController.suma(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void suma_con_valores_negativos() {
        var mockResultado = BigDecimal.valueOf(-5);
        when(calculatorService.suma(any(), any())).thenReturn(mockResultado);
        var responseEntity = calculatorController.suma(BigDecimal.valueOf(-2), BigDecimal.valueOf(-3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void suma_con_valor_positivo_y_negativo() {
        var mockResultado = BigDecimal.valueOf(-1);
        when(calculatorService.suma(any(), any())).thenReturn(mockResultado);
        var responseEntity = calculatorController.suma(BigDecimal.valueOf(2), BigDecimal.valueOf(-3));
        compruebaRespuestaOK(responseEntity, mockResultado);

        mockResultado = BigDecimal.valueOf(1);
        when(calculatorService.suma(any(), any())).thenReturn(mockResultado);
        responseEntity = calculatorController.suma(BigDecimal.valueOf(-2), BigDecimal.valueOf(3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void resta_con_valores_positivos() {
        var mockResultado = BigDecimal.valueOf(-1);
        when(calculatorService.resta(any(), any())).thenReturn(mockResultado);
        var responseEntity = calculatorController.resta(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void resta_con_valores_negativos() {
        var mockResultado = BigDecimal.valueOf(1);
        when(calculatorService.resta(any(), any())).thenReturn(mockResultado);
        var responseEntity = calculatorController.resta(BigDecimal.valueOf(-2), BigDecimal.valueOf(-3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void resta_con_valor_positivo_y_negativo() {
        var mockResultado = BigDecimal.valueOf(5);
        when(calculatorService.resta(any(), any())).thenReturn(mockResultado);
        var responseEntity = calculatorController.resta(BigDecimal.valueOf(2), BigDecimal.valueOf(-3));
        compruebaRespuestaOK(responseEntity, mockResultado);

        mockResultado = BigDecimal.valueOf(-5);
        when(calculatorService.resta(any(), any())).thenReturn(mockResultado);
        responseEntity = calculatorController.resta(BigDecimal.valueOf(-2), BigDecimal.valueOf(3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    private void compruebaRespuestaOK(ResponseEntity<BigDecimal> responseEntity, BigDecimal mockResultado) {
        var statusCode = responseEntity.getStatusCode();
        var resultado = responseEntity.getBody();
        Assertions.assertTrue(statusCode.is2xxSuccessful());
        Assertions.assertEquals(mockResultado, resultado);
    }
}
