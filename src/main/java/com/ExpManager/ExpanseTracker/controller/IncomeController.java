package com.ExpManager.ExpanseTracker.controller;

import com.ExpManager.ExpanseTracker.dto.IncomeDTO;
import com.ExpManager.ExpanseTracker.entity.Income;
import com.ExpManager.ExpanseTracker.services.Income.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDTO){
        Income createdIncome = incomeService.postIncome(incomeDTO);
        if(createdIncome!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
