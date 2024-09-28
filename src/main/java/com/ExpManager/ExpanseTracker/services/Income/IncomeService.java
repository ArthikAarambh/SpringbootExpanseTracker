package com.ExpManager.ExpanseTracker.services.Income;

import com.ExpManager.ExpanseTracker.dto.IncomeDTO;
import com.ExpManager.ExpanseTracker.entity.Income;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);
}
