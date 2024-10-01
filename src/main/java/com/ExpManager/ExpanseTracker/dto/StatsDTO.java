package com.ExpManager.ExpanseTracker.dto;

import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.entity.Income;
import lombok.Data;

@Data
public class StatsDTO {
    private Double income;
    private Double expanse;
    private Income latestIncome;
    private Expanse latestExpanse;
    private Double balance;
    private Double minIncome;
    private Double maxIncome;
    private Double minExpanse;
    private Double maxExpanse;

}
