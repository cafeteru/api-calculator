package es.cafeteru.apicalculator.controllers;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cafeteru.apicalculator.services.CalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

@RestController
@AllArgsConstructor
@Slf4j
public class CalculatorController {
    private CalculatorService calculatorService;

    @GetMapping("/suma")
    public ResponseEntity<BigDecimal> suma(
        @RequestParam BigDecimal sumando1, @RequestParam BigDecimal sumando2) {
        log.info("suma({}, {}) - start", sumando1, sumando2);
        var resultado = calculatorService.suma(sumando1, sumando2);
        var tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("suma({}, {}) - end", sumando1, sumando2);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
