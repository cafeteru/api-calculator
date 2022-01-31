package es.cafeteru.apicalculator.services.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import es.cafeteru.apicalculator.services.CalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal suma(BigDecimal sumando1, BigDecimal sumando2) {
        log.info("suma({}, {}) - start", sumando1, sumando2);
        BigDecimal resultado = sumando1.add(sumando2);
        TracerImpl tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("suma({}, {}) - end", sumando1, sumando2);
        return resultado;
    }

    @Override
    public BigDecimal resta(BigDecimal minuendo, BigDecimal sustraendo) {
        log.info("resta({}, {}) - start", minuendo, sustraendo);
        BigDecimal resultado = minuendo.subtract(sustraendo);
        TracerImpl tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("resta({}, {}) - end", minuendo, sustraendo);
        return resultado;
    }
}
