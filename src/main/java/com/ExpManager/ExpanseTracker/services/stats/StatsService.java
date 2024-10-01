package com.ExpManager.ExpanseTracker.services.stats;

import com.ExpManager.ExpanseTracker.dto.GraphDTO;
import com.ExpManager.ExpanseTracker.dto.StatsDTO;

public interface StatsService {
    GraphDTO getChartData();
    StatsDTO getStats();
}
