package com.worldline.interview.widgetmachine;

import com.worldline.interview.widgetmachine.dto.WidgetDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WidgetMachineTest {
    @Test
    public void testCombustionEngineWithSteamFuelType() {
        try{
            WidgetMachine combustionMachine = new WidgetMachine(new InternalCombustionEngine(FuelType.WOOD));
        } catch (IllegalStateException e){
            assertEquals("Cannot fill internal combustion engine with WOOD", e.getMessage());
        }

    }

    @Test
    public void testSteamEngineWithCombustionFuel() {
        try{
            WidgetMachine steamMachine = new WidgetMachine(new SteamEngine(FuelType.DIESEL));
        } catch (IllegalStateException e){
            assertEquals("Cannot fill steam engine with DIESEL", e.getMessage());
        }

    }

    @Test
    public void testCombustionMachinePetrol(){
        // If expected number of widgets produced is 104 and cost per batch of petrol powered machine is £9
        // 104 / 8 = 13 -> 13 times
        // cost = 13 * 9 = £117
        // Petrol powered machine should cost £116 and produce 104 widgets

        BigDecimal expectedCost = new BigDecimal("117");
        int expectedWidgets = 104;

        Engine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 100);

        WidgetMachine combustionMachinePetrol = new WidgetMachine(engine);

        WidgetDTO widgetDTO = combustionMachinePetrol.produceWidgets(104);

        assertEquals(expectedCost, widgetDTO.getTotalCost());
        assertEquals(expectedWidgets, widgetDTO.getTotalWidgets());
    }

    @Test
    public void testCombustionMachineDiesel(){
        // If expected number of widgets produced is 96 and cost per batch of diesel powered machine is £12
        // 96 / 8 = 12 -> 12 times
        // cost = 12 * 12 = £144
        // Diesel powered machine should cost £116 and produce 104 widgets

        BigDecimal expectedCost = new BigDecimal("144");
        int expectedWidgets = 96;

        Engine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 100);

        WidgetMachine combustionMachinePetrol = new WidgetMachine(engine);

        WidgetDTO widgetDTO = combustionMachinePetrol.produceWidgets(96);

        assertEquals(expectedCost, widgetDTO.getTotalCost());
        assertEquals(expectedWidgets, widgetDTO.getTotalWidgets());
    }

    @Test
    public void testSteamMachineWood(){
        // If expected number of widgets produced is 16 and cost per batch of wood powered machine is £4.35
        // 16 / 2 = 8 -> 8 times
        // cost = 8 * 4.35 = £34.8
        // Wood  powered machine should cost £34.8 and produce 16 widgets

        BigDecimal expectedCost = new BigDecimal("34.80");
        int expectedWidgets = 16;

        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 100);

        WidgetMachine combustionMachinePetrol = new WidgetMachine(engine);

        WidgetDTO widgetDTO = combustionMachinePetrol.produceWidgets(16);

        assertEquals(expectedCost, widgetDTO.getTotalCost());
        assertEquals(expectedWidgets, widgetDTO.getTotalWidgets());
    }

    @Test
    public void testSteamMachineCoal(){
        // If expected number of widgets produced is 20 and cost per batch of coal powered machine is £5.65
        // 20 / 2 = 10 -> 10 times
        // cost = 10 * 5.65 = £56.50
        // Coal powered machine should cost £56.50 and produce 20 widgets

        BigDecimal expectedCost = new BigDecimal("56.50");
        int expectedWidgets = 20;

        Engine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 100);

        WidgetMachine combustionMachinePetrol = new WidgetMachine(engine);

        WidgetDTO widgetDTO = combustionMachinePetrol.produceWidgets(20);

        assertEquals(expectedCost, widgetDTO.getTotalCost());
        assertEquals(expectedWidgets, widgetDTO.getTotalWidgets());
    }
}
