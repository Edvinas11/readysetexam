package com.readysetexam.readysetexam.api.model;

import java.time.LocalDate;

public class DailyAvailability {
    private LocalDate date;
    private int freeHours;

    // Constructors, getters, and setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getFreeHours() {
        return freeHours;
    }

    public void setFreeHours(int freeHours) {
        this.freeHours = freeHours;
    }
}
