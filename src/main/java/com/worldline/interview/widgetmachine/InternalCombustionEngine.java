package com.worldline.interview.widgetmachine;

import java.math.BigDecimal;

public class InternalCombustionEngine extends Engine {

    private int batch = 8;

    public InternalCombustionEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
        validateFuelType(requiredFuelType);
    }

    @Override
    public int getBatch() {
        return batch;
    }

    @Override
    public void fill(FuelType fuelType, int fuelLevel){
        validateFuelType(fuelType);
        super.fill(fuelType, fuelLevel);
    }

    private void validateFuelType(FuelType fuelType){
        if(!fuelType.equals(FuelType.PETROL) && !fuelType.equals(FuelType.DIESEL)){
            throw new IllegalStateException("Cannot fill internal combustion engine with " + requiredFuelType);
        }
    }

}
