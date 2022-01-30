package es.cafeteru.apicalculator.services.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import es.cafeteru.apicalculator.services.CalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal suma(BigDecimal sumando1, BigDecimal sumando2) {
        log.info("suma({}, {}) - start", sumando1, sumando2);
        var resultado = sumando1.add(sumando2);
        var tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("suma({}, {}) - end", sumando1, sumando2);
        return resultado;
    }

    @Override
    public BigDecimal resta(BigDecimal minuendo, BigDecimal sustraendo) {
        log.info("resta({}, {}) - start", minuendo, sustraendo);
        var resultado = minuendo.subtract(sustraendo);
        var tracer = new TracerImpl();
        tracer.trace(resultado);
        log.info("resta({}, {}) - end", minuendo, sustraendo);
        return resultado;
    }
}
