package com.ExpManager.ExpanseTracker.services.Income;

import com.ExpManager.ExpanseTracker.dto.IncomeDTO;
import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.entity.Income;
import com.ExpManager.ExpanseTracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImp implements IncomeService {
    private final IncomeRepository incomeRepository;


    public Income postIncome(IncomeDTO incomeDTO) {
        return saveOrUpdateExpanse(new Income(), incomeDTO);
    }

    private Income saveOrUpdateExpanse(Income income, IncomeDTO incomeDTO) {
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setDescription(incomeDTO.getDescription());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        return incomeRepository.save(income);

    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll().stream().sorted(Comparator.comparing(Income::getDate).reversed())
                .collect(Collectors.toList());
    }

    public Income updateIncome(Long id, IncomeDTO incomeDTO) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()) {
            return saveOrUpdateExpanse(optionalIncome.get(), incomeDTO);
        } else {
            throw new EntityNotFoundException("income is not present with id : " + id);
        }
    }

    public Income getIncomeById(Long id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()){
            return optionalIncome.get();
        }else {
            throw new EntityNotFoundException("Income is not present with id : " + id);
        }
    }

    public void deleteIncome(Long id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            incomeRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Income is not present with id : " + id);
        }
    }
}
