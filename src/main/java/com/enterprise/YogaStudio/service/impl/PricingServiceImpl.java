package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.repository.PriceRepository;
import com.enterprise.YogaStudio.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingServiceImpl implements PricingService {

    @Autowired
    private PriceRepository pricingRepository;

    @Override
    public Pricing addPricingDetails(Pricing pricingModel) {
        return pricingRepository.save(pricingModel);

    }
}
