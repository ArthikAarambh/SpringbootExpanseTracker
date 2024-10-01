package com.ExpManager.ExpanseTracker.services.stats;

import com.ExpManager.ExpanseTracker.dto.GraphDTO;
import com.ExpManager.ExpanseTracker.repository.ExpanseRepository;
import com.ExpManager.ExpanseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {
    private final IncomeRepository incomeRepository;
    private final ExpanseRepository expanseRepository;

    public GraphDTO getChartData(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);
        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setExpanseList(expanseRepository.findByDateBetween(startDate,endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate,endDate));
        return graphDTO;
    }

}
