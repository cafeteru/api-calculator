package es.cafeteru.apicalculator.controllers;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        @RequestParam BigDecimal sumando1,
        @ApiParam(name = "sumando2", example = "0", value = "Segundo número para sumar")
        @RequestParam BigDecimal sumando2) {
        log.info("suma({}, {}) - start", sumando1, sumando2);
        BigDecimal resultado = calculatorService.suma(sumando1, sumando2);
        TracerImpl tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("suma({}, {}) - end", sumando1, sumando2);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/resta")
    @ApiOperation(value = "Resta dos números")
    public ResponseEntity<BigDecimal> resta(
        @ApiParam(name = "minuendo", example = "0", value = "Número al que se le va a restar")
        @RequestParam BigDecimal minuendo,
        @ApiParam(name = "sustraendo", example = "0", value = "Número que se resta")
        @RequestParam BigDecimal sustraendo) {
        log.info("resta({}, {}) - start", minuendo, sustraendo);
        BigDecimal resultado = calculatorService.resta(minuendo, sustraendo);
        TracerImpl tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("resta({}, {}) - end", minuendo, sustraendo);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
