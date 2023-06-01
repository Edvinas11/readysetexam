package com.readysetexam.readysetexam.api.model;

import java.time.LocalDate;
import java.util.List;

public class PreparationSchedule {
    private LocalDate examDate;
    private int totalPreparationTime;
    private List<DailyPreparation> dailyPreparation;

    // Constructors, getters, and setters
    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public int getTotalPreparationTime() {
        return totalPreparationTime;
    }

    public void setTotalPreparationTime(int totalPreparationTime) {
        this.totalPreparationTime = totalPreparationTime;
    }

    public List<DailyPreparation> getDailyPreparation() {
        return dailyPreparation;
    }

    public void setDailyPreparation(List<DailyPreparation> dailyPreparation) {
        this.dailyPreparation = dailyPreparation;
    }
}
