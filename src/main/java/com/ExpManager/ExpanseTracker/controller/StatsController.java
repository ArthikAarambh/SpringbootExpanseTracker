package com.ExpManager.ExpanseTracker.controller;

import com.ExpManager.ExpanseTracker.dto.GraphDTO;
import com.ExpManager.ExpanseTracker.services.stats.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {
    public final StatsService statsService;

    @GetMapping("/chart")
    public ResponseEntity<GraphDTO> getChartsDetails() {
        return ResponseEntity.ok(statsService.getChartData());
    }

    @GetMapping
    public ResponseEntity<?>getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }
}
