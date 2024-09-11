package com.ExpManager.ExpanseTracker.controller;

import com.ExpManager.ExpanseTracker.dto.ExpanseDTO;
import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.services.Expanse.ExpanseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expanse")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpanseController {
    private final ExpanseService expanseService;

    @PostMapping
    public ResponseEntity<?> postExpanse(@RequestBody ExpanseDTO dto){
        Expanse createdExpanse = expanseService.postExpanse(dto);
        if(createdExpanse != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpanse);

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
