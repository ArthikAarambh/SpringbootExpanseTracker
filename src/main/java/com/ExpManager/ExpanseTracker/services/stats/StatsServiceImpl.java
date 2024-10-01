package com.ExpManager.ExpanseTracker.services.stats;

import com.ExpManager.ExpanseTracker.dto.GraphDTO;
import com.ExpManager.ExpanseTracker.dto.StatsDTO;
import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.entity.Income;
import com.ExpManager.ExpanseTracker.repository.ExpanseRepository;
import com.ExpManager.ExpanseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {
    private final IncomeRepository incomeRepository;
    private final ExpanseRepository expanseRepository;

    public GraphDTO getChartData() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);
        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setExpanseList(expanseRepository.findByDateBetween(startDate, endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));
        return graphDTO;
    }

    public StatsDTO getStats() {
        Double totalExpanse = expanseRepository.sumAllAmounts();
        Double totalIncome = incomeRepository.sumAllAmounts();
        Optional<Expanse> optionalExpanse = expanseRepository.findFirstByOrderByDateDesc();
        Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setExpanse(totalExpanse);
        statsDTO.setIncome(totalIncome);
        optionalExpanse.ifPresent(statsDTO::setLatestExpanse);
        optionalIncome.ifPresent(statsDTO::setLatestIncome);
        statsDTO.setBalance(totalIncome - totalExpanse);
        List<Income> incomeList = incomeRepository.findAll();
        List<Expanse> expanseList = expanseRepository.findAll();
        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();
        OptionalDouble minExpanse = expanseList.stream().mapToDouble(Expanse::getAmount).min();
        OptionalDouble maxExpanse = expanseList.stream().mapToDouble(Expanse::getAmount).max();
        statsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);
        statsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);
        statsDTO.setMaxExpanse(maxExpanse.isPresent() ? maxExpanse.getAsDouble() : null);
        statsDTO.setMinExpanse(minExpanse.isPresent() ? minExpanse.getAsDouble() : null);
        return statsDTO;
    }
}
