package com.ExpManager.ExpanseTracker.dto;

import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {
    private List<Expanse>expanseList;
    private List<Income>incomeList;

}
