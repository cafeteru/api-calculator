package es.cafeteru.apicalculator.services.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import es.cafeteru.apicalculator.model.Operacion;
import es.cafeteru.apicalculator.model.Resta;
import es.cafeteru.apicalculator.model.Suma;
import es.cafeteru.apicalculator.services.CalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal suma(Operacion sumando1, Operacion sumando2) {
        log.info("suma({}, {}) - start", sumando1, sumando2);
        Operacion operacion = new Suma(sumando1, sumando2);
        BigDecimal resultado = operacion.ejecutar();
        TracerImpl tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("suma({}, {}) - end", sumando1, sumando2);
        return resultado;
    }

    @Override
    public BigDecimal resta(Operacion minuendo, Operacion sustraendo) {
        log.info("resta({}, {}) - start", minuendo, sustraendo);
        Operacion operacion = new Resta(minuendo, sustraendo);
        BigDecimal resultado = operacion.ejecutar();
        TracerImpl tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("resta({}, {}) - end", minuendo, sustraendo);
        return resultado;
    }
}
