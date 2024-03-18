package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DiscountRepository extends JpaRepository<Discount, Integer>{
}
