package com.worldline.interview.widgetmachine;

import java.math.BigDecimal;

public class SteamEngine extends Engine {

    private int batch = 2;

    public SteamEngine(FuelType requiredFuelType) {
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
        if(!fuelType.equals(FuelType.WOOD) && !fuelType.equals(FuelType.COAL)){
            throw new IllegalStateException("Cannot fill steam engine with " + requiredFuelType);
        }
    }
}
