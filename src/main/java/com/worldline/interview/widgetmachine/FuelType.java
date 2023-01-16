package com.worldline.interview.widgetmachine;

import java.math.BigDecimal;

public enum FuelType {
    PETROL(new BigDecimal("9")), DIESEL(new BigDecimal("12")), WOOD(new BigDecimal("4.35")), COAL(new BigDecimal("5.65"));

    private final BigDecimal cost;

    FuelType(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost(){
        return cost;
    }
}
