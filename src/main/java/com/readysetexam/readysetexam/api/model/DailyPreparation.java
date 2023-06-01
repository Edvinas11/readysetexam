package com.readysetexam.readysetexam.api.model;

import java.time.LocalDate;

public class DailyPreparation {
    private LocalDate date;
    private int preparationTime;

    // Constructors, getters, and setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}
