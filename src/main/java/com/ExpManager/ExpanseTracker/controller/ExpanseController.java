package com.ExpManager.ExpanseTracker.controller;

import com.ExpManager.ExpanseTracker.dto.ExpanseDTO;
import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.services.Expanse.ExpanseService;
import jakarta.persistence.EntityNotFoundException;
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

    @GetMapping("/all")
    public ResponseEntity<?> getAllExpanses(){
        return ResponseEntity.ok(expanseService.getAllExpanses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getExpanseByid(@PathVariable Long id){
        try {
            return ResponseEntity.ok(expanseService.getExpanseByid(id));
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }
    }
}
