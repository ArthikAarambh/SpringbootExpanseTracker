package com.ExpManager.ExpanseTracker.repository;

import com.ExpManager.ExpanseTracker.entity.Expanse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpanseRepository extends JpaRepository<Expanse,Long> {

}
