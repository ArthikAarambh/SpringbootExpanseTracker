package com.ExpManager.ExpanseTracker.services.Expanse;

import com.ExpManager.ExpanseTracker.ExpanseTrackerApplication;
import com.ExpManager.ExpanseTracker.dto.ExpanseDTO;
import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.repository.ExpanseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpanseServiceImp implements ExpanseService{
    private final ExpanseRepository expanseRepository;


    public Expanse postExpanse(ExpanseDTO expanseDTO){
        return saveOrUpdateExpanse(new Expanse(),expanseDTO);
    }
    private Expanse saveOrUpdateExpanse(Expanse expanse, ExpanseDTO expanseDTO){

        expanse.setTitle(expanseDTO.getTitle());
        expanse.setDate(expanseDTO.getDate());
        expanse.setAmount(expanseDTO.getAmount());
        expanse.setCategory(expanseDTO.getCategory());
        expanse.setDescription(expanseDTO.getDescription());

        return expanseRepository.save(expanse);
    }
}
