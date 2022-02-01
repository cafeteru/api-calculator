package es.cafeteru.apicalculator.services.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import es.cafeteru.apicalculator.model.Operacion;
import es.cafeteru.apicalculator.model.Resta;
import es.cafeteru.apicalculator.model.Suma;
import es.cafeteru.apicalculator.services.CalculatorService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal identificaOperador(Operacion op1, Operacion op2, String operador) {
        switch (operador) {
            case "+":
                return new Suma(op1, op2).ejecutar();
            case "-":
                return new Resta(op1, op2).ejecutar();
            default:
                throw new IllegalArgumentException("Operador no definido");
        }
    }
}
