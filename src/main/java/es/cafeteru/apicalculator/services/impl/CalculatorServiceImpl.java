package es.cafeteru.apicalculator.services.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import es.cafeteru.apicalculator.services.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal suma(BigDecimal sumando1, BigDecimal sumando2) {
        return BigDecimal.ZERO;
    }
}
