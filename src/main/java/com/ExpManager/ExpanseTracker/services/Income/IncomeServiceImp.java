package com.ExpManager.ExpanseTracker.services.Income;

import com.ExpManager.ExpanseTracker.dto.IncomeDTO;
import com.ExpManager.ExpanseTracker.entity.Income;
import com.ExpManager.ExpanseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeServiceImp implements IncomeService {
    private final IncomeRepository incomeRepository;


    public Income postIncome(IncomeDTO incomeDTO){
        return saveOrUpdateExpanse(new Income(),incomeDTO);
    }

    private Income saveOrUpdateExpanse(Income income, IncomeDTO incomeDTO){
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setDescription(incomeDTO.getDescription());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        return incomeRepository.save(income);

    }
}
