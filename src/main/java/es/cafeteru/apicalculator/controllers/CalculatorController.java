package es.cafeteru.apicalculator.controllers;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CalculatorController {

    @GetMapping("/suma")
    public ResponseEntity<BigDecimal> suma(
        @RequestParam BigDecimal sumando1, @RequestParam BigDecimal sumando2) {
        log.info("{} + {}", sumando1, sumando2);
        return new ResponseEntity<>(BigDecimal.ZERO, HttpStatus.OK);
    }
}
