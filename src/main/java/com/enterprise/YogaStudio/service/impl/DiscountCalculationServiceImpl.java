package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Discount;
import com.enterprise.YogaStudio.service.DiscountCalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class DiscountCalculationServiceImpl implements DiscountCalculationService {
    public int calculateAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
        return period.getYears();
    }
    public BigDecimal calculateDiscountedPrice(BigDecimal originalPrice, BigDecimal discountPercent) {
        return originalPrice.multiply(BigDecimal.ONE.subtract(discountPercent.divide(new BigDecimal("100"))));
    }
    public Discount getApplicableDiscount(int age, List<Discount> discounts) {
        for (Discount discount : discounts) {
            if (age >= discount.getMinAge() && age <= discount.getMaxAge()) {
                return discount;
            }
        }
        return null;
    }
}