package es.cafeteru.apicalculator.services.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import es.cafeteru.apicalculator.services.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal suma(BigDecimal sumando1, BigDecimal sumando2) {
        log.info("suma({}, {}) - start", sumando1, sumando2);
        var resultado = sumando1.add(sumando2);
        log.info("suma({}, {}) - end", sumando1, sumando2);
        return resultado;
    }
}
