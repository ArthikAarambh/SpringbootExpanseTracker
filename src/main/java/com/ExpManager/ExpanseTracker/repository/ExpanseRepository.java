package com.ExpManager.ExpanseTracker.repository;

import com.ExpManager.ExpanseTracker.entity.Expanse;
import com.ExpManager.ExpanseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpanseRepository extends JpaRepository<Expanse,Long> {
    List<Expanse> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
