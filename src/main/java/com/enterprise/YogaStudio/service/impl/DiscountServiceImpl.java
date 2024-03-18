package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Discount;
import com.enterprise.YogaStudio.repository.DiscountRepository;
import com.enterprise.YogaStudio.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Discount> getDiscountList() {
        return discountRepository.findAll();
    }
}
