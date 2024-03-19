package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {
    List<Discount> getDiscountList();
}
