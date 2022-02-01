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

    @GetMapping("/")
    @ApiOperation(value = "Suma dos números")
    public ResponseEntity<BigDecimal> operacion(
        @ApiParam(name = "sumando1", example = "0", value = "Primer número para sumar")
        @RequestParam String sumando1,
        @ApiParam(name = "sumando2", example = "0", value = "Segundo número para sumar")
        @RequestParam String sumando2,
        @ApiParam(name = "operador", example = "+", value = "Operador")
        @RequestParam String operador
    ) {
        try {
            log.info("operacion({}, {}, {}) - start", sumando1, sumando2, operador);
            Operacion op1 = new Numero(BigDecimal.valueOf(Double.parseDouble(sumando1)));
            Operacion op2 = new Numero(BigDecimal.valueOf(Double.parseDouble(sumando2)));
            BigDecimal resultado = calculatorService.identificaOperador(op1, op2, operador);
            TracerImpl tracer = new TracerImpl();
            tracer.trace(resultado);
            log.info("operacion({}, {}, {}) - end", sumando1, sumando2, operador);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (NumberFormatException | NullPointerException e) {
            log.error("operacion({}, {}, {}) - error: {}", sumando1, sumando2, operador, e.getMessage());
            throw new IllegalArgumentException("Error al leer los parámetros");
        }
    }
}
