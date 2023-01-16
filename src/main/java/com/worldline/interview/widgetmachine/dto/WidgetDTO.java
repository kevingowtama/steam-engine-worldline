package com.worldline.interview.widgetmachine.dto;

import java.math.BigDecimal;

public class WidgetDTO {

    private BigDecimal totalCost;
    private int totalWidgets;
    public WidgetDTO() {
        this.totalCost = new BigDecimal("0");
        this.totalWidgets = 0;
    }
    public WidgetDTO(BigDecimal totalCost, int totalWidgets) {
        this.totalCost = totalCost;
        this.totalWidgets = totalWidgets;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalWidgets() {
        return totalWidgets;
    }

    public void setTotalWidgets(int totalWidgets) {
        this.totalWidgets = totalWidgets;
    }

}
