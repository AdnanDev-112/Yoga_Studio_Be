package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.YogaRetreat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface YogaRetreatRepository extends JpaRepository<YogaRetreat, Integer> {


}
