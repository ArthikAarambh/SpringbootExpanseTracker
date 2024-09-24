package com.ExpManager.ExpanseTracker.services.Expanse;

import com.ExpManager.ExpanseTracker.ExpanseTrackerApplication;
import com.ExpManager.ExpanseTracker.dto.ExpanseDTO;
import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.repository.ExpanseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Expanse> getAllExpanses(){
        return expanseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expanse::getDate).reversed())
                .collect(Collectors.toList());
    }

    public Expanse getExpanseByid(Long id){
        Optional<Expanse> optionalExpanse = expanseRepository.findById(id);
        if (optionalExpanse.isPresent()){
            return optionalExpanse.get();
        }else {
            throw new EntityNotFoundException("Expanse is not present with id : "+id);
        }
    }
}
