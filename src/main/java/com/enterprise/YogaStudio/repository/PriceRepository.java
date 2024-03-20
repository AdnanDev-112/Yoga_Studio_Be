package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Pricing, Integer> {
}
