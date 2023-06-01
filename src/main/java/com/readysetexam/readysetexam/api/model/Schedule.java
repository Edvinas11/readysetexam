package com.readysetexam.readysetexam.api.model;

import java.time.LocalDate;
import java.util.List;

public class Schedule {
    private LocalDate examDate;
    private List<DailyAvailability> dailyAvailability;

    // Constructors, getters, and setters
    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public List<DailyAvailability> getDailyAvailability() {
        return dailyAvailability;
    }

    public void setDailyAvailability(List<DailyAvailability> dailyAvailability) {
        this.dailyAvailability = dailyAvailability;
    }
}


