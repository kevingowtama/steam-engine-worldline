package com.worldline.interview.widgetmachine;

import java.math.BigDecimal;

public abstract class Engine {

    private boolean running;

    private final int fuelCostPerRun = 5; // Assume one batch deducts fuel level by 5

    private int fuelLevel;
    protected FuelType requiredFuelType;
    protected FuelType fuelType;

    public abstract int getBatch();

    public Engine(FuelType requiredFuelType) {
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public void use() {
        if(fuelLevel < fuelCostPerRun){
            System.out.println("Low fuel. Engine is no longer usable");
        } else {
            fuelLevel -= fuelCostPerRun;
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return requiredFuelType;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public BigDecimal getCost(){
        return requiredFuelType.getCost();
    }

    public int getFuelCostPerRun() {
        return fuelCostPerRun;
    }
}
