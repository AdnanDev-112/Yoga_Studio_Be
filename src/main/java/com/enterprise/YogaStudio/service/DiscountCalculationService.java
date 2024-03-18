package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Discount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public interface DiscountCalculationService {

    public int calculateAge(LocalDate dob);

    public BigDecimal calculateDiscountedPrice(BigDecimal originalPrice, BigDecimal discountPercent);

    public Discount getApplicableDiscount(int age, List<Discount> discounts);
}

