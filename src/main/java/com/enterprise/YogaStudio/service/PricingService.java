package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Pricing;
import org.springframework.stereotype.Service;

@Service
public interface PricingService {

    public Pricing addPricingDetails(Pricing pricingModel);
}
