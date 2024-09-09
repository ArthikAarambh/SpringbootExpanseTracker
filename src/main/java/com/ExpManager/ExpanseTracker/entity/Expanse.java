package com.ExpManager.ExpanseTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Expanse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//it will autoINcrement the id when new expanse is added.
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDate date;
    private Integer amount;

}
