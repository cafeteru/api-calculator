package es.cafeteru.apicalculator.controllers;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cafeteru.apicalculator.model.Numero;
import es.cafeteru.apicalculator.model.Operacion;
import es.cafeteru.apicalculator.services.CalculatorService;
import io.corp.calculator.TracerImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j

public class CalculatorController {
    private CalculatorService calculatorService;

    @GetMapping("/suma")
    @ApiOperation(value = "Suma dos números")
    public ResponseEntity<BigDecimal> suma(
        @ApiParam(name = "sumando1", example = "0", value = "Primer número para sumar")
        @RequestParam String sumando1,
        @ApiParam(name = "sumando2", example = "0", value = "Segundo número para sumar")
        @RequestParam String sumando2) {
        try {
            log.info("suma({}, {}) - start", sumando1, sumando2);
            Operacion op1 = new Numero(BigDecimal.valueOf(Double.parseDouble(sumando1)));
            Operacion op2 = new Numero(BigDecimal.valueOf(Double.parseDouble(sumando2)));
            BigDecimal resultado = calculatorService.suma(op1, op2);
            TracerImpl tracer = new TracerImpl();
            tracer.trace(resultado);
            log.info("suma({}, {}) - end", sumando1, sumando2);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (NumberFormatException | NullPointerException e) {
            log.error("suma({}, {}) - error: {}", sumando1, sumando2, e.getMessage());
            throw new IllegalArgumentException("Error al leer los parámetros");
        }
    }

    @GetMapping("/resta")
    @ApiOperation(value = "Resta dos números")
    public ResponseEntity<BigDecimal> resta(
        @ApiParam(name = "minuendo", example = "0", value = "Número al que se le va a restar")
        @RequestParam String minuendo,
        @ApiParam(name = "sustraendo", example = "0", value = "Número que se resta")
        @RequestParam String sustraendo) {
        try {
            log.info("resta({}, {}) - start", minuendo, sustraendo);
            Operacion op1 = new Numero(BigDecimal.valueOf(Double.parseDouble(minuendo)));
            Operacion op2 = new Numero(BigDecimal.valueOf(Double.parseDouble(sustraendo)));
            BigDecimal resultado = calculatorService.resta(op1, op2);
            TracerImpl tracer = new TracerImpl();
            tracer.trace(resultado);
            log.info("resta({}, {}) - end", minuendo, sustraendo);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (NumberFormatException | NullPointerException e) {
            log.error("resta({}, {}) - error: {}", minuendo, sustraendo, e.getMessage());
            throw new IllegalArgumentException("Error al leer los parámetros");
        }
    }
}
