package com.worldline.interview.widgetmachine;

import com.worldline.interview.widgetmachine.dto.WidgetDTO;

import java.math.BigDecimal;

public class WidgetMachine {
    private Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public WidgetDTO produceWidgets(int quantity) {
        engine.start();
        WidgetDTO widgetDTO = new WidgetDTO();

        if (engine.isRunning()) {
            widgetDTO = produce(quantity);
        }

        engine.stop();

        System.out.println("Total cost -> £" + widgetDTO.getTotalCost());
        System.out.println("Total widgets produced -> " + widgetDTO.getTotalWidgets());
        return widgetDTO;
    }

    private WidgetDTO produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        BigDecimal costPerBatch = engine.getCost();

        while (batch < quantity && engine.getFuelLevel() >= engine.getFuelCostPerRun()) {
            engine.use();
            batch = batch + engine.getBatch();
            batchCount++;
        }

        return new WidgetDTO(costPerBatch.multiply(BigDecimal.valueOf(batchCount)), batch);
    }


}
