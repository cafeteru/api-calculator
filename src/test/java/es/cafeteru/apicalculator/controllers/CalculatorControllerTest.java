package es.cafeteru.apicalculator.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.cafeteru.apicalculator.services.CalculatorService;

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
        BigDecimal mockResultado = BigDecimal.valueOf(5);
        when(calculatorService.suma(any(), any())).thenReturn(mockResultado);
        ResponseEntity<BigDecimal> responseEntity = calculatorController.suma(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void suma_con_valores_negativos() {
        BigDecimal mockResultado = BigDecimal.valueOf(-5);
        when(calculatorService.suma(any(), any())).thenReturn(mockResultado);
        ResponseEntity<BigDecimal> responseEntity = calculatorController.suma(BigDecimal.valueOf(-2), BigDecimal.valueOf(-3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void suma_con_valor_positivo_y_negativo() {
        BigDecimal mockResultado = BigDecimal.valueOf(-1);
        when(calculatorService.suma(any(), any())).thenReturn(mockResultado);
        ResponseEntity<BigDecimal> responseEntity = calculatorController.suma(BigDecimal.valueOf(2), BigDecimal.valueOf(-3));
        compruebaRespuestaOK(responseEntity, mockResultado);

        mockResultado = BigDecimal.valueOf(1);
        when(calculatorService.suma(any(), any())).thenReturn(mockResultado);
        responseEntity = calculatorController.suma(BigDecimal.valueOf(-2), BigDecimal.valueOf(3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void resta_con_valores_positivos() {
        BigDecimal mockResultado = BigDecimal.valueOf(-1);
        when(calculatorService.resta(any(), any())).thenReturn(mockResultado);
        ResponseEntity<BigDecimal> responseEntity = calculatorController.resta(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void resta_con_valores_negativos() {
        BigDecimal mockResultado = BigDecimal.valueOf(1);
        when(calculatorService.resta(any(), any())).thenReturn(mockResultado);
        ResponseEntity<BigDecimal> responseEntity = calculatorController.resta(BigDecimal.valueOf(-2), BigDecimal.valueOf(-3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    @Test
    void resta_con_valor_positivo_y_negativo() {
        BigDecimal mockResultado = BigDecimal.valueOf(5);
        when(calculatorService.resta(any(), any())).thenReturn(mockResultado);
        ResponseEntity<BigDecimal> responseEntity = calculatorController.resta(BigDecimal.valueOf(2), BigDecimal.valueOf(-3));
        compruebaRespuestaOK(responseEntity, mockResultado);

        mockResultado = BigDecimal.valueOf(-5);
        when(calculatorService.resta(any(), any())).thenReturn(mockResultado);
        responseEntity = calculatorController.resta(BigDecimal.valueOf(-2), BigDecimal.valueOf(3));
        compruebaRespuestaOK(responseEntity, mockResultado);
    }

    private void compruebaRespuestaOK(ResponseEntity<BigDecimal> responseEntity, BigDecimal mockResultado) {
        HttpStatus statusCode = responseEntity.getStatusCode();
        BigDecimal resultado = responseEntity.getBody();
        Assertions.assertTrue(statusCode.is2xxSuccessful());
        Assertions.assertEquals(mockResultado, resultado);
    }
}
