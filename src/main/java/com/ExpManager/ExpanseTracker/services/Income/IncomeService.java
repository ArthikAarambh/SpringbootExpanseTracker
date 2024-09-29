package com.ExpManager.ExpanseTracker.services.Income;

import com.ExpManager.ExpanseTracker.dto.IncomeDTO;
import com.ExpManager.ExpanseTracker.entity.Income;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);

    List<Income> getAllIncomes();

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    Income getIncomeById(Long id);
    void deleteIncome(Long id);
}
