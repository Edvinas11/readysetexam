package com.readysetexam.readysetexam.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.readysetexam.readysetexam.api.model.DailyAvailability;
import com.readysetexam.readysetexam.api.model.DailyPreparation;

@Service
public class ScheduleService {

    // Pomodoro Technique is a time management method developed by Francesco Cirillo.
    // In this API we will use 4 pomodors (1 session) which means that total working time is 2 hours.
    private static final int POMODORO_WORK_TIME = 2;

    public List<DailyPreparation> CalculateDailyPreparation(List<DailyAvailability> dailyAvailability) {
        List<DailyPreparation> dailyPreparations = new ArrayList<>();
        int preparationTime = 0;
        int pomodoroSessions = 0;
        int time = 0;
        LocalDate date = null;
        LocalDate[] specialDates = {
            LocalDate.of(2023, 12, 24), // Christmas Eve
            LocalDate.of(2023, 12, 25), // Christmas
            LocalDate.of(2023, 01, 01), // New Year's day
            // Add more special dates if needed.
        };

        for(DailyAvailability availability : dailyAvailability) {
            DailyPreparation dailyPreparation = new DailyPreparation();
            boolean isEqual = false;
            preparationTime = availability.getFreeHours();
            date = availability.getDate();

            // Check if date is special one. If so, relax and chill that day :).
            for(LocalDate specialDate : specialDates) {
                if((specialDate.getMonthValue() == date.getMonthValue()) && (specialDate.getDayOfMonth() == date.getDayOfMonth())){
                    isEqual = true;
                }
                else {
                    isEqual = false;
                }
            }
            if(isEqual){
                time = 0;
            }
            else {
                pomodoroSessions = preparationTime / POMODORO_WORK_TIME;
                time = pomodoroSessions * POMODORO_WORK_TIME;
            }
            
            dailyPreparation.setPreparationTime(time);
            dailyPreparation.setDate(date);
            dailyPreparations.add(dailyPreparation);
        }

        return dailyPreparations;
    }

    public int CalculateTotalPreparationTime(List<DailyPreparation> dailyPreparation) {
        int totalPreparationTime = 0;

        for(DailyPreparation preparation : dailyPreparation) {
            totalPreparationTime += preparation.getPreparationTime();
        }

        return totalPreparationTime;
    }
}
