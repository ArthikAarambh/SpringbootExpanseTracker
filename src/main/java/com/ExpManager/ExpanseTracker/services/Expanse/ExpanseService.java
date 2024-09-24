package com.ExpManager.ExpanseTracker.services.Expanse;

import com.ExpManager.ExpanseTracker.dto.ExpanseDTO;
import com.ExpManager.ExpanseTracker.entity.Expanse;

import java.util.List;

public interface ExpanseService {
    Expanse postExpanse(ExpanseDTO expanseDTO);

    List<Expanse> getAllExpanses();

    Expanse getExpanseByid(Long id);

    Expanse updateExpanse(Long id, ExpanseDTO expanseDTO);

    void deleteExpanse(Long id);

}
