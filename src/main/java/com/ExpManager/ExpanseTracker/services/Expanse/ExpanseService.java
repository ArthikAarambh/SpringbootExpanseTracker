package com.ExpManager.ExpanseTracker.services.Expanse;

import com.ExpManager.ExpanseTracker.dto.ExpanseDTO;
import com.ExpManager.ExpanseTracker.entity.Expanse;

public interface ExpanseService {
    Expanse postExpanse(ExpanseDTO expanseDTO);

}
