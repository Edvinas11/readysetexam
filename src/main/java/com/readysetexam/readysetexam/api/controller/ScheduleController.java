package com.readysetexam.readysetexam.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.readysetexam.readysetexam.api.model.DailyAvailability;
import com.readysetexam.readysetexam.api.model.DailyPreparation;
import com.readysetexam.readysetexam.api.model.PreparationSchedule;
import com.readysetexam.readysetexam.api.model.Schedule;
import com.readysetexam.readysetexam.service.ScheduleService;

@RestController
public class ScheduleController {
    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/calculateschedule")
    public ResponseEntity<PreparationSchedule> calculateSchedule(@RequestBody Schedule request) {
        LocalDate examDate = request.getExamDate();
        List<DailyAvailability> dailyAvailability = request.getDailyAvailability();
        
        List<DailyPreparation> dailyPreparation = scheduleService.CalculateDailyPreparation(dailyAvailability);
        int totalPreparationTime = scheduleService.CalculateTotalPreparationTime(dailyPreparation);

        // Create a response
        PreparationSchedule response = new PreparationSchedule();
        response.setExamDate(examDate);
        response.setTotalPreparationTime(totalPreparationTime);
        response.setDailyPreparation(dailyPreparation);

        return ResponseEntity.ok(response);
    }
}
